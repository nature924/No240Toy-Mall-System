package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.RoyaltyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户提成表
 * @author Wsy
 */
@Mapper
public interface RoyaltyDao extends BaseMapper<RoyaltyEntity> {
}