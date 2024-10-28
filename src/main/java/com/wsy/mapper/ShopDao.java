package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ShopEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 * @author Wsy
 */
@Mapper
public interface ShopDao extends BaseMapper<ShopEntity> {
}