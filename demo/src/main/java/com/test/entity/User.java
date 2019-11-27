package com.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User extends BaseEntity implements Serializable {

    private Integer userId;

    private String userName;

    private String password;

    private Integer age;

    private String sex;
}
