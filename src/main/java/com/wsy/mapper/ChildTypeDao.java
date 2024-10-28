package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ChildTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类表
 * @author Wsy
 */
@Mapper
public interface ChildTypeDao extends BaseMapper<ChildTypeEntity> {
}