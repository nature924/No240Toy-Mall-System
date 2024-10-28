package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ShoppingGatEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 购物车
 * @author Wsy
 */
@Mapper
public interface ShoppingGatDao extends BaseMapper<ShoppingGatEntity> {
}