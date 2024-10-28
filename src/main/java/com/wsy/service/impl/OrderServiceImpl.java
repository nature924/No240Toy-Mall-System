package com.wsy.service.impl;

import com.wsy.mapper.OrderDao;
import com.wsy.model.OrderEntity;
import com.wsy.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderDao,OrderEntity> implements OrderService{
}