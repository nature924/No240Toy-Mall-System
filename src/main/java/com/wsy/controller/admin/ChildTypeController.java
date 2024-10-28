package com.wsy.controller.admin;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.wsy.config.PageVo;
import com.wsy.config.Result;
import com.wsy.model.ChildTypeEntity;
import com.wsy.service.ChildTypeService;
import com.wsy.table.ChildTypeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 普通用户管理
 */
@Controller
@RequestMapping("childType")
public class ChildTypeController {

    @Autowired
    private ChildTypeService childTypeService  ;

    /**
     * 根据1级分类查询2级分类
     * @param type
     * @return
     */
    @PostMapping("childList.htm")
    @ResponseBody
    public Result childList(Integer type){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<ChildTypeEntity> list =  childTypeService.selectList(entityWrapper);
        return Result.success(list);
    }

    /**
     * 根据1级分类查询2级分类
     * @param type
     * @return
     */
    @PostMapping("childList.do")
    @ResponseBody
    public Result childListdo(Integer type){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<ChildTypeEntity> list =  childTypeService.selectList(entityWrapper);
        return Result.success(list);
    }


    /**
     * 列表
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("indexPage.htm")
    public String indexPage(Model model)throws Exception{
       return "childType/list";
    }


    /**
     * 分页
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("page.htm")
    @ResponseBody
    public PageVo indexPage(Model model, String name, int page , int limit)throws Exception{

        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.like(ChildTypeTable.NAME,name);


        Page<ChildTypeEntity> paged = new Page();
        paged.setSize(limit);
        paged.setCurrent(page);
        Page<ChildTypeEntity> userTablePage = childTypeService.selectPage(paged, entityWrapper);

        PageVo<ChildTypeEntity> pageVo = new PageVo<>();
        pageVo.setCode(0);
        pageVo.setCount(paged.getTotal());
        pageVo.setData(userTablePage.getRecords());
        pageVo.setPageNum(limit);
        pageVo.setPageSize(page);
        return pageVo;

    }

    /**
     * 保存界面
     * @param model
     * @return
     */
    @GetMapping("savePage.htm")
    public String savePage(Model model){
        return  "childType/save";
    }

    /**
     * 保存
     * @param model
     * @return
     */
    @PostMapping("save.htm")
    @ResponseBody
    public Result savePage(Model model , ChildTypeEntity entity){
        if(entity.getId()==null || entity.getId().equals("")){
            entity.setId(IdWorker.get32UUID());
            childTypeService.insert(entity);
        }
        return Result.success("用户保存成功");
    }



}
