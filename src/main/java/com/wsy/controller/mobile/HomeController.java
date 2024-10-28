package com.wsy.controller.mobile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wsy.config.Contants;
import com.wsy.model.ArticleEntity;
import com.wsy.model.ChildTypeEntity;
import com.wsy.model.CustomerEntity;
import com.wsy.service.*;
import com.wsy.table.ArticleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页
 */
@Controller
public class HomeController {

    @Autowired
    private ShopTypeService shopTypeService;

    @Autowired
    private ShopService shopService;


    @Autowired
    private ArticleService articleService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChildTypeService childTypeService;


    /**
     * 首页
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public String home(Model model)throws Exception{
        CustomerEntity customerEntity = Contants.getCustomer();
        if(customerEntity!=null){
            model.addAttribute("customer",customerEntity);
        }

        return "shoping/index";
    }


    @RequestMapping("articleHome.html")
    public String articleHome(Model model)throws Exception{
        //查询置顶
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq(ArticleTable.STATUS,1).eq("top",1).orderBy("time",false);
        List<ArticleEntity> topArticle =  articleService.selectList(wrapper);
        if(topArticle!=null && !topArticle.isEmpty()){
            for (ArticleEntity articleEntity : topArticle) {
                articleEntity.setCustomerName("系统发布");
                CustomerEntity userEntity = customerService.selectById(articleEntity.getCustomerId());
                articleEntity.setCustomerEntity(userEntity);
            }
        }
        model.addAttribute("topArticle",topArticle);

        //查询分类
        List<ChildTypeEntity> list =   childTypeService.selectList(new EntityWrapper<>());
        model.addAttribute("childTypes",list);

        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq(ArticleTable.STATUS,1);
        entityWrapper.orderBy("time",false);

        List<ArticleEntity> articleEntities = articleService.selectList(entityWrapper);
        if(articleEntities!=null && !articleEntities.isEmpty()){
            for (ArticleEntity articleEntity : articleEntities) {
                articleEntity.setCustomerName("系统发布");
                CustomerEntity userEntity = customerService.selectById(articleEntity.getCustomerId());
                articleEntity.setCustomerEntity(userEntity);
                ChildTypeEntity childTypeEntity = childTypeService.selectById(articleEntity.getChildType());
                if(childTypeEntity!=null){
                    articleEntity.setChildName(childTypeEntity.getName());
                }
            }
        }
        model.addAttribute("articleEntities",articleEntities);

        return "mobile/articleHome";
    }


}
