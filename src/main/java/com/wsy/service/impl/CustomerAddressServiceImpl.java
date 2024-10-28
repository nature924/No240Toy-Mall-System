package com.wsy.service.impl;

import com.wsy.mapper.CustomerAddressDao;
import com.wsy.model.CustomerAddressEntity;
import com.wsy.service.CustomerAddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户收货地址
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerAddressServiceImpl extends ServiceImpl<CustomerAddressDao,CustomerAddressEntity> implements CustomerAddressService{
}