package com.wsy.controller.pay;

import cn.hutool.core.util.IdUtil;
import com.wsy.config.Contants;
import com.wsy.entity.UserEntity;
import com.wsy.model.CustomerEntity;
import com.wsy.model.OrderEntity;
import com.wsy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class PayController {
    @Autowired
    @Qualifier("alipayService")
    private AlipayService alipayService;
    @Autowired
    CustomerService customerService;
    @Autowired
    private ShoppingGatService shoppingGatService;
    @Autowired
    private OrderService orderService;
    @Autowired
    public Jedis jedis;

    @RequestMapping("/useIntegral")
    public void useIntegral() {
        System.out.println("true");
        jedis.set("WSY-INTEGRALFLAG", "true");
    }

    @RequestMapping("/unUseIntegral")
    public void unUseIntegral() {
        System.out.println("false");
        jedis.set("WSY-INTEGRALFLAG", "false");
    }

    @RequestMapping("/pay")
    @ResponseBody
    public String payController(@RequestParam("ids") String ids[], @RequestParam("amount") String amount) throws Exception {
        String name = jedis.get("WSY-SHOPID");
        jedis.del("WSY-IDS");
        for (String id : ids) {
            jedis.lpush("WSY-IDS", id);
        }
        double s = Double.parseDouble(amount);
        Integer pay = (int) s;
        Integer flag = (int) s;
        CustomerEntity customer = Contants.getCustomer();
        CustomerEntity customerEntity = customerService.selectById(customer.getId());
        Integer integral = customerEntity.getIntegral();
        String INTEGRALFLA = jedis.get("WSY-INTEGRALFLAG");
        if (integral != null && integral > 0 && "true".equals(INTEGRALFLA)) {
            pay = pay - integral;
            if (pay < 0) {
                pay = 0;
                integral = integral - flag;
            } else {
                integral = 0;
            }
            jedis.set("WSY-FLAG", "true");
            jedis.set("WSY-INTEGRAL", String.valueOf(integral));
            jedis.set("WSY-USERID", customerEntity.getId());
        } else {
            jedis.set("WSY-FLAG", "false");
        }
        name = name.substring(0, name.length() - 1);
        String id = IdUtil.simpleUUID();
//        String pays = alipayService.webPagePay(id, pay, name);
        return "下单成功";
    }

    @RequestMapping("/payresult")
    private String payResult() {
        List<String> ids = jedis.lrange("WSY-IDS", 0, -1);
        jedis.del("WSY-IDS");
        for (String id : ids) {
            shoppingGatService.deleteById(id);
        }
        String flag = jedis.get("WSY-FLAG");
        if ("true".equals(flag)) {
            String integralStr = jedis.get("WSY-INTEGRAL");
            Integer integralInt = Integer.valueOf(integralStr);
            String userId = jedis.get("WSY-USERID");
            CustomerEntity customerEntity = customerService.selectById(userId);
            customerEntity.setIntegral(integralInt);
            customerService.updateById(customerEntity);
        }
        String orderId = jedis.get("WSY-ORDERID");
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderId);
        orderEntity.setStatus(1);
        orderService.updateById(orderEntity);
        return "shoping/index";
    }
}
