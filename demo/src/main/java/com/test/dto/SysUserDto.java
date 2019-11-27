package com.test.dto;

import com.test.utils.pager.Pager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_user")
@Data
@ApiModel
public class SysUserDto extends Pager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 用户名，登录名
     */
    @ApiModelProperty(value = "用户名，登录名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 性别
0：女
1：男
2：保密 
     */
    @ApiModelProperty(value = "性别")
    private Integer sex;

    /**
     * 职业类型：
1：Java开发
2：前端开发
3：大数据开发
4：ios开发
5：Android开发
6：Linux系统工程师
7：PHP开发
8：.net开发
9：C/C++
10：学生
11：其它
     */
    @ApiModelProperty(value = "职业类型")
    private Integer job;

    /**
     * 头像地址
     */
    @Column(name = "face_image")
    @ApiModelProperty(value = "头像地址")
    private String faceImage;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String district;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 用于权限的“盐”
     */
    @Column(name = "auth_salt")
    @ApiModelProperty(value = "用于权限的“盐”")
    private String authSalt;

    /**
     * 最后一次登录IP
     */
    @Column(name = "last_login_ip")
    @ApiModelProperty(value = "最后一次登录IP")
    private String lastLoginIp;

    /**
     * 最后一次登录时间
     */
    @Column(name = "last_login_time")
    @ApiModelProperty(value = "最后一次登录时间")
    private Date lastLoginTime;

    @Column(name = "is_delete")
    @ApiModelProperty(value = "is_delete")
    private Integer isDelete;

    @Column(name = "regist_time")
    @ApiModelProperty(value = "注册时间")
    private Date registTime;
}