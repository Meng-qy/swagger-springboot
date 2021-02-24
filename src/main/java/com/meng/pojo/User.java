package com.meng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


//给实体类添加文档注释
@ApiModel(value = "User",description = "用户信息")
public class User  implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户名")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(value = "密码")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
