package com.wsy.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wsy.entity.RoleEntity;
import com.wsy.mapper.RoleDao;
import com.wsy.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService{
}