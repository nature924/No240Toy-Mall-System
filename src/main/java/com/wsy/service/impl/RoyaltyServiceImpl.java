package com.wsy.service.impl;

import com.wsy.mapper.RoyaltyDao;
import com.wsy.model.RoyaltyEntity;
import com.wsy.service.RoyaltyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户提成表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoyaltyServiceImpl extends ServiceImpl<RoyaltyDao,RoyaltyEntity> implements RoyaltyService{
}