package com.wsy.service.impl;

import com.wsy.mapper.ArticleShopDao;
import com.wsy.model.ArticleShopEntity;
import com.wsy.service.ArticleShopService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章商品表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleShopServiceImpl extends ServiceImpl<ArticleShopDao,ArticleShopEntity> implements ArticleShopService{
}