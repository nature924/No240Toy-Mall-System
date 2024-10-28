package com.wsy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wsy.model.ArticleShopEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章商品表
 * @author Wsy
 */
@Mapper
public interface ArticleShopDao extends BaseMapper<ArticleShopEntity> {
}