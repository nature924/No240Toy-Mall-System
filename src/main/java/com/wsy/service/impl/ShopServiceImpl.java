package com.wsy.service.impl;

import com.wsy.mapper.ShopDao;
import com.wsy.model.ShopEntity;
import com.wsy.service.ShopService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShopServiceImpl extends ServiceImpl<ShopDao,ShopEntity> implements ShopService{
}