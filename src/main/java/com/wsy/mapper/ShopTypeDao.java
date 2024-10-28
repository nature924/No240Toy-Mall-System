package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ShopTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品类型
 * @author Wsy
 */
@Mapper
public interface ShopTypeDao extends BaseMapper<ShopTypeEntity> {
}