package com.imblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imblog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}