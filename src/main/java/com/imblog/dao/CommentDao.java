package com.imblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imblog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao extends BaseMapper<Comment> {
}
