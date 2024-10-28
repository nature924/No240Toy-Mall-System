package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.OrderCommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单评价表
 * @author Wsy
 */
@Mapper
public interface OrderCommentDao extends BaseMapper<OrderCommentEntity> {
}