package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户表
 * @author Wsy
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select user.*,role.name role_name from user left join role on user.role_id = role.id order by user.time ")
    List<UserEntity> list();
}