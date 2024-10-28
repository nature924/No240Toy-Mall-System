package com.wsy.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wsy.entity.UserEntity;
import com.wsy.mapper.UserDao;
import com.wsy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService{
}