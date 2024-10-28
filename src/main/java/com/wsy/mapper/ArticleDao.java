package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表
 * @author Wsy
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {
}