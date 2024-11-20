package com.imblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imblog.pojo.Label;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabelDao extends BaseMapper<Label> {
}