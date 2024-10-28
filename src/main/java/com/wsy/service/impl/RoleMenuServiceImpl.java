package com.wsy.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wsy.entity.RoleMenuEntity;
import com.wsy.mapper.RoleMenuDao;
import com.wsy.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色菜单表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenuEntity> implements RoleMenuService{
}