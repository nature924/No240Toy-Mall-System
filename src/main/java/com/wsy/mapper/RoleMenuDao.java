package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色菜单表
 * @author Wsy
 */
@Mapper
public interface RoleMenuDao extends BaseMapper<RoleMenuEntity> {
}