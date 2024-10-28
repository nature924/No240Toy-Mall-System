package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * @author Wsy
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
}