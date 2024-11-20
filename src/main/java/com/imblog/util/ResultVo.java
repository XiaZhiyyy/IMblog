package com.imblog.util;

import lombok.Data;

/**
 * 项目:demo-xihua
 * 描述: 统一响应类
 * 时间:2024/6/17 14:47
 * 作者:admin
 * 版本:1.0
 **/
@Data
public class ResultVo {

     //状态码: 成功:200 ,失败:500
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private Object data;

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //成功01
    public static ResultVo success(){
        return new ResultVo(200,"success",null);
    }
    //成功02
    public static ResultVo success(String msg,Object data){
        return new ResultVo(200,msg,data);
    }
    //成功03
    public static ResultVo success(String msg){
        return new ResultVo(200,msg,null);
    }

    //失败01
    public static ResultVo error(){
        return new ResultVo(500,"fail",null);
    }
    //失败02
    public static ResultVo error(String msg){
        return new ResultVo(500,msg,null);
    }




}
