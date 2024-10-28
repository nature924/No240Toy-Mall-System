package com.wsy.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wsy.entity.MenuEntity;
import com.wsy.mapper.MenuDao;
import com.wsy.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService{
}