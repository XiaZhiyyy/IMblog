package com.imblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imblog.dao.UserInfoDao;
import com.imblog.pojo.UserInfo;
import com.imblog.service.UserInfoService;
import com.imblog.util.ResultVo;
import com.imblog.util.SHA3Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service    //服务层
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;
    @Override
    public ResultVo add(UserInfo userInfo) {
        try {
            // 判断用户是否已存在
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("member_name",userInfo.getMemberName());
            UserInfo u = userInfoDao.selectOne(queryWrapper); //定义新的UserInfo对象u，存储查询结果
            if(u != null){
                return ResultVo.error("用户已存在");
            }
            //生成盐值
            String salt = SHA3Util.generateRandomSalt(16);
            //合并盐值加密密码
            String newPwd = SHA3Util.hashWithSalt(userInfo.getMemberPassword(),salt);
            //存入盐值和加密的密码
            userInfo.setSalt(salt);
            userInfo.setMemberPassword(newPwd);
            int bool = userInfoDao.insert(userInfo);
            if (bool > 0) {
                return ResultVo.success("注册成功");
            } else {
                return ResultVo.error("注册失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResultVo.error("注册异常");
        }
    }

    @Override
    public ResultVo update(UserInfo userInfo) {
        try {
            //生成盐值
            String salt = SHA3Util.generateRandomSalt(16);
            //合并盐值加密密码
            String newPwd = SHA3Util.hashWithSalt(userInfo.getMemberPassword(),salt);
            //存入盐值和加密的密码
            userInfo.setSalt(salt);
            userInfo.setMemberPassword(newPwd);
            int bool = userInfoDao.updateById(userInfo);
            if (bool > 0) {
                return ResultVo.success("修改成功");
            } else {
                return ResultVo.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResultVo.error("修改异常");
        }
    }

    @Override
    public ResultVo del(Integer id) {
        try{
            int l = userInfoDao.deleteById(id);
            if(l > 0){
                return ResultVo.success("删除目录条数："+ l);
            }else{
                return ResultVo.error("删除数据为空");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVo.error("删除异常");
        }
    }

    @Override
    public ResultVo query(String name) {
        try{
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            boolean is = name!=null&&!name.equals("");
            queryWrapper.like(is,"member_name",name);    //必须和数据库表中一致
            // 条件不成立，默认查询所有
            List<UserInfo> list = userInfoDao.selectList(queryWrapper);
            if(list.size() > 0){
                return ResultVo.success("查询数据结果：",list);
            }else{
                return ResultVo.error("查询数据为空");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVo.error("查询异常");
        }
    }

    @Override
    public ResultVo login(UserInfo userInfo) {
        //1 验证码用户名是否正确
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_name",userInfo.getMemberName());
        UserInfo u =userInfoDao.selectOne(queryWrapper);
        if(u==null){
            return ResultVo.error("用户名不正确");
        }

        System.out.println("输入的密码：" + userInfo.getMemberPassword());
        System.out.println("数据库中的盐值：" + u.getSalt());

        //2 输入的密码加密
        String pwd = SHA3Util.hashWithSalt(userInfo.getMemberPassword(),u.getSalt());

        System.out.println("加密后的密码：" + pwd);
        System.out.println("数据库中的密码：" + u.getMemberPassword());
        System.out.println("数据库中的用户名：" + u.getMemberName());

        if(pwd.equals(u.getMemberPassword())){
            return ResultVo.success("允许登录");
        }
        return ResultVo.error("密码不正确");
    }
}
