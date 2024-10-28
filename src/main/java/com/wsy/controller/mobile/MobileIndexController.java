package com.wsy.controller.mobile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wsy.model.ShopEntity;
import com.wsy.model.ShopTypeEntity;
import com.wsy.service.ShopService;
import com.wsy.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mobile")
public class MobileIndexController {


    @Autowired
    private ShopTypeService shopTypeService;

    @Autowired
    private ShopService shopService;

    /**
     * 首页
     * @return
     * @throws Exception
     */
    @GetMapping("index.html")
    public String index(Model model)throws Exception{
        List<ShopTypeEntity> types = shopTypeService.selectList(new EntityWrapper<>());
        model.addAttribute("types",types);
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("status",true);
        List<ShopEntity> shopEntities =  shopService.selectList(wrapper);
        model.addAttribute("shops",shopEntities);
        if(shopEntities!=null){
            List<ShopEntity> hot1 = new ArrayList<>();
            List<List<ShopEntity>> hots = new ArrayList<>();
            for (ShopEntity shopEntity : shopEntities) {
                if(shopEntity.isHot()){
                    hot1.add(shopEntity);
                }
            }
            for (int i = 0; i <(hot1.size()%4==0?hot1.size()/4:hot1.size()/4+1) ; i++) {
                int end = (i+1)*4;
                if(end>hot1.size()-1){
                    end = hot1.size()-1;
                }
                hots.add(hot1.subList(i*4,end));
            }
            model.addAttribute("hots",hots);
        }
        return "mobile/index";
    }

}
