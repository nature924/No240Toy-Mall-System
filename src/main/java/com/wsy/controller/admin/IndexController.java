package com.wsy.controller.admin;

import com.wsy.config.Contants;
import com.wsy.entity.MenuEntity;
import com.wsy.entity.RoleEntity;
import com.wsy.entity.UserEntity;
import com.wsy.mapper.MenuDao;
import com.wsy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuDao menuDao;



    /**
     * 首页
     * @return
     */
    @RequestMapping("index.htm")
    public String index(Model model){
        UserEntity userEntity = Contants.get();
        model.addAttribute("userEntity",userEntity);

        RoleEntity roleEntity = roleService.selectById(userEntity.getRoleId());
        model.addAttribute("roleEntity",roleEntity);

        List<MenuEntity> menuEntities = menuDao.selectByRoleId(roleEntity.getId());
        List<MenuEntity> one = new ArrayList<>();
        for (MenuEntity menuEntity : menuEntities) {
            if(menuEntity.getType()==1){
                one.add(menuEntity);
            }
        }
        for (MenuEntity menuEntity : one) {
            List<MenuEntity> two = menuEntity.getChilds();
            if(two==null){
                two = new ArrayList<>();
            }
            for (MenuEntity entity : menuEntities) {
                if(entity.getType() == 2 && menuEntity.getId().equals(entity.getPId())){
                    two.add(entity);
                }
            }
            menuEntity.setChilds(two);
        }
        model.addAttribute("menus",one);
        return "index";
    }
}
