package com.wsy.service.impl;

import com.wsy.mapper.ShoppingGatDao;
import com.wsy.model.ShoppingGatEntity;
import com.wsy.service.ShoppingGatService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 购物车
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingGatServiceImpl extends ServiceImpl<ShoppingGatDao,ShoppingGatEntity> implements ShoppingGatService{
}