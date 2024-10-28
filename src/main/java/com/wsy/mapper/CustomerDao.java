package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户表
 * @author Wsy
 */
@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
}