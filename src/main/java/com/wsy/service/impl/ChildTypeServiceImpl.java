package com.wsy.service.impl;

import com.wsy.mapper.ChildTypeDao;
import com.wsy.model.ChildTypeEntity;
import com.wsy.service.ChildTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 分类表
 * @author Wsy
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ChildTypeServiceImpl extends ServiceImpl<ChildTypeDao,ChildTypeEntity> implements ChildTypeService{
}