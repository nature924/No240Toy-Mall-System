package com.wsy.service.impl;

import com.wsy.mapper.CustomerDao;
import com.wsy.model.CustomerEntity;
import com.wsy.service.CustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl extends ServiceImpl<CustomerDao,CustomerEntity> implements CustomerService{
}