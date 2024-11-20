package com.imblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imblog.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper //数据层
public interface UserInfoDao extends BaseMapper<UserInfo> { //利用MP封装好的BaseMapper接口方法对表进行增删改查
}
