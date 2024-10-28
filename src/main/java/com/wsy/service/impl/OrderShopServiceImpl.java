package com.wsy.service.impl;

import com.wsy.mapper.OrderShopDao;
import com.wsy.model.OrderShopEntity;
import com.wsy.service.OrderShopService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单购物详情
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderShopServiceImpl extends ServiceImpl<OrderShopDao,OrderShopEntity> implements OrderShopService{
}