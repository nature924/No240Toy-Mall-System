package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.CustomerAddressEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户收货地址
 * @author Wsy
 */
@Mapper
public interface CustomerAddressDao extends BaseMapper<CustomerAddressEntity> {
}