package com.wsy.service.impl;

import com.wsy.mapper.ArticleDao;
import com.wsy.model.ArticleEntity;
import com.wsy.service.ArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl extends ServiceImpl<ArticleDao,ArticleEntity> implements ArticleService{
}