package com.wsy.controller.admin;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wsy.config.IdWorkerUtil;
import com.wsy.config.PageVo;
import com.wsy.config.Result;
import com.wsy.model.*;
import com.wsy.service.*;
import com.wsy.table.ArticleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChildTypeService childTypeService;

    @Autowired
    private ArticleShopService articleShopService;

    @Autowired
    private ShopService shopService;





    /**
     * 界面
     * @return
     * @throws Exception
     */
    @GetMapping("list.htm")
    public String list(Model model)throws Exception{
        return "article/list";
    }


    /**
     * 分页
     * @return
     * @throws Exception
     */
    @GetMapping("page.htm")
    @ResponseBody
    public PageVo page(String title, String  summary,int page , int limit)throws Exception{
        EntityWrapper entityWrapper = new EntityWrapper();
        if(!StringUtils.isEmpty(title)){
            entityWrapper.like(ArticleTable.TITLE,title);
        }
        if(!StringUtils.isEmpty(summary)){
            entityWrapper.like(ArticleTable.SUMMARY,summary);
        }
        entityWrapper.orderBy("top",false).orderBy("time",false);
        Page<ArticleEntity> paged = new Page();
        paged.setSize(limit);
        paged.setCurrent(page);
        Page<ArticleEntity> userTablePage = articleService.selectPage(paged, entityWrapper);

        List<ArticleEntity> list = userTablePage.getRecords();
        if(list!=null && !list.isEmpty()){
            for (ArticleEntity articleEntity : list) {
                CustomerEntity customerEntity = customerService.selectById(articleEntity.getCustomerId());
                if(customerEntity!=null){
                    articleEntity.setCustomerName(customerEntity.getName());
                }
                ChildTypeEntity childTypeEntity = childTypeService.selectById(articleEntity.getChildType());
                if(childTypeEntity!=null){
                    articleEntity.setChildName(childTypeEntity.getName());
                }
            }
        }
        PageVo<ArticleEntity> pageVo = new PageVo<>();
        pageVo.setCode(0);
        pageVo.setCount(paged.getTotal());
        pageVo.setData(list);
        pageVo.setPageNum(limit);
        pageVo.setPageSize(page);
        return pageVo;

    }

    /**
     * 界面
     * @return
     * @throws Exception
     */
    @GetMapping("add.htm")
    public String add(Model model)throws Exception{
        List<ShopEntity> shopEntities =  shopService.selectList(new EntityWrapper<>());
        model.addAttribute("shopEntities",shopEntities);
        return "article/add";
    }


    /**
     * 保存数据
     * @return
     * @throws Exception
     */
    @RequestMapping("addData.htm")
    @ResponseBody
    public Result addDatax(ArticleEntity articleEntity, HttpSession session)throws Exception{
        articleEntity.setId(IdWorkerUtil.getId());
        articleEntity.setTime(new Date());
        articleEntity.setStatus(1);
        articleEntity.setCustomerId("-1");
        articleService.insert(articleEntity);
        return Result.success("保存成功");
    }


    /**
     * 根据文章ID推荐商品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("shopList.html")
    @ResponseBody
    public Result shopList(String id)throws Exception{
        ArticleEntity articleEntity = articleService.selectById(id);
        if(StringUtils.isEmpty(articleEntity.getLabel())){
            return Result.success("无");
        }
        String[] lebel = articleEntity.getLabel().split(",");
        //查询
        List<String> ids = new ArrayList<>();
        for (String s : lebel) {
            EntityWrapper wrapper = new EntityWrapper();
            wrapper.like("label",s);
            List<ShopEntity> shops = shopService.selectList(wrapper);
            if(shops!=null){
                for (ShopEntity shop : shops) {
                    ids.add(shop.getId());
                }
            }
        }
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.in("id",ids).orderBy("rand()");
        List<ShopEntity> shops = shopService.selectList(wrapper);
        if(shops!=null){
            if(shops.size()>3){
                shops = shops.subList(0,3);
            }
        }
        return Result.success(shops);
    }


    /**
     * 界面
     * @return
     * @throws Exception
     */
    @GetMapping("info.html")
    public String info(String id, Model model)throws Exception{
        ArticleEntity articleEntity = articleService.selectById(id);
        model.addAttribute("article",articleEntity);
        model.addAttribute("id",id);
        String[]  lebel = articleEntity.getLabel().split(",");
        model.addAttribute("lebels",lebel);
        CustomerEntity customerEntity = customerService.selectById(articleEntity.getCustomerId());
        model.addAttribute("customerEntity",customerEntity);
        if(!StringUtils.isEmpty(articleEntity.getShopIds())){
            String articles[] = articleEntity.getShopIds().split(",");
            List<String> str = new ArrayList<>();
            for (String article : articles) {
                str.add(article);
            }
            List<ShopEntity> shopEntities = shopService.selectBatchIds(str);
            model.addAttribute("shopEntities",shopEntities);
        }
        return "article/info";
    }


    /**
     * 界面
     * @return
     * @throws Exception
     */
    @GetMapping("edit.htm")
    public String edit(String id, Model model )throws Exception{
        ArticleEntity articleEntity = articleService.selectById(id);
        model.addAttribute("articleEntity",articleEntity);
        List<ShopEntity> shopEntities =  shopService.selectList(new EntityWrapper<>());
        model.addAttribute("shopEntities",shopEntities);
        return "article/edit";
    }

    /**
     * 保存数据
     * @return
     * @throws Exception
     */
    @RequestMapping("editData.htm")
    @ResponseBody
    public Result editData(ArticleEntity articleEntity)throws Exception{
        articleService.updateById(articleEntity);
        return Result.success("保存成功");
    }


}
