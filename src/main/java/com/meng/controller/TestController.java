package com.meng.controller;

import com.meng.exception.BizException;
import com.meng.exception.ResultBody;
import com.meng.pojo.User;
import com.meng.utils.ResultCode;
import com.meng.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@Api(value = "用户控制层",tags = {"用户控制层"})
public class TestController {


    @GetMapping("/index")
    public String index(){
        return "hello world";
    }

    @RequestMapping("/user")
    //放在请求接口的方法上
    @ApiOperation("用户名密码测试")
    public ReturnResult user(@ApiParam(value = "用户密码") User user){
        if(user.getUsername()==null){
            throw  new BizException(-1,"用户姓名不能为空！");
        }
        return ReturnResult.successed(user);
    }
}
