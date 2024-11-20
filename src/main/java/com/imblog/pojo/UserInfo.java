package com.imblog.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("blog_member")   //连接博客成员数据库
public class UserInfo {
    @TableId(value = "member_id" , type = IdType.AUTO)   //主键
    private Integer memberId;

    @TableField("member_level")
    private Integer memberLevel;

    @TableField("member_name")
    private String memberName;

    @TableField("member_password")
    private String memberPassword;

    @TableField("member_email")
    private String memberEmail;

    //设置盐值
    @TableField("salt")
    private String salt;

}
