package com.imblog.controller;

import com.imblog.pojo.UserInfo;
import com.imblog.service.UserInfoService;
import com.imblog.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController //控制器
@RequestMapping("/admin")
public class UserInfoController {

    @Autowired  //服务层接口
    UserInfoService userInfoService;
    @RequestMapping("/test")
    public String test(){
        return "4555";
    }
    @PostMapping("/add")
    public ResultVo add(@RequestBody UserInfo userInfo){
        return userInfoService.add(userInfo);
    }
    @PostMapping("/login")
    public ResultVo login(@RequestBody UserInfo userInfo){
        return userInfoService.login(userInfo);
    }

    @PutMapping("/update")
    public ResultVo update(@RequestBody UserInfo userInfo){
        return userInfoService.update(userInfo);
    }

    //查询
    //get 请求更快，明文传输
    @GetMapping("/query")
    public ResultVo query(String memberName){
        return userInfoService.query(memberName);
    }

    @GetMapping("/del")
    public ResultVo del(Integer memberId){return userInfoService.del(memberId);}
}
