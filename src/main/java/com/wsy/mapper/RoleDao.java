package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表
 * @author Wsy
 */
@Mapper
public interface RoleDao extends BaseMapper<RoleEntity> {
}