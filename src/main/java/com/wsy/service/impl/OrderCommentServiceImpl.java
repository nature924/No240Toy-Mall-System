package com.wsy.service.impl;

import com.wsy.mapper.OrderCommentDao;
import com.wsy.model.OrderCommentEntity;
import com.wsy.service.OrderCommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单评价表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderCommentServiceImpl extends ServiceImpl<OrderCommentDao,OrderCommentEntity> implements OrderCommentService{
}