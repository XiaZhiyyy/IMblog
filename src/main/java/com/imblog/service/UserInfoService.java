package com.imblog.service;

import com.imblog.pojo.UserInfo;
import com.imblog.util.ResultVo;

public interface UserInfoService {
    ResultVo add(UserInfo userInfo);
    ResultVo update(UserInfo userInfo);
    //删除
    ResultVo del(Integer member_id);
    //查询
    ResultVo query(String member_name);

    ResultVo login(UserInfo userInfo);
}
