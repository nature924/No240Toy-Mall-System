package com.wsy.service.impl;

import com.wsy.mapper.ShopTypeDao;
import com.wsy.model.ShopTypeEntity;
import com.wsy.service.ShopTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品类型
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeDao,ShopTypeEntity> implements ShopTypeService{
}