package com.test.controller;

import com.test.dto.SysUserDto;
import com.test.entity.SysUser;
import com.test.entity.User;
import com.test.service.SysUserService;
import com.test.utils.ResultResponse;
import com.test.utils.TableResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@Api(tags = "用户相关接口")
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/userInfoTest", method = RequestMethod.GET)
    @ApiOperation("测试是否能够请求接口")
    public ResultResponse userInfo() {
        User user = new User();
        user.setAge(10);
        user.setPassword("password");
        user.setSex("男");
        user.setUserId(1);
        user.setUserName("userName");
        return ResultResponse
                .success(user);
    }

    @PostMapping("/signUser")
    @ApiOperation("注册用户接口")
    public ResultResponse signUser(@RequestBody SysUser user) {
        SysUser sysUser = sysUserService.signUser(user);
        return ResultResponse.success(sysUser);
    }

    @GetMapping("/selectUserById/{id}")
    @ApiOperation("根据用户id查询单个用户接口")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public ResultResponse selectUserById(@PathVariable Integer id) {
        logger.info("开始根据用户id查询单个用户--------------" + new Date());
        SysUser user = sysUserService.selectUserById(id);
        logger.info("结束根据用户id查询单个用户--------------" + new Date());
        return ResultResponse.success(user);
    }

    @PutMapping("/updUser")
    @ApiOperation("修改用户信息接口")
    public ResultResponse updUser(@RequestBody SysUser user) {
        user = sysUserService.updUser(user);
        return ResultResponse.success(user);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation("删除用户信息接口")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public ResultResponse deleteById(@PathVariable Integer id) {
        sysUserService.deleteById(id);
        return ResultResponse.success();
    }

    @PostMapping("getList")
    public TableResultResponse getList(@RequestBody SysUserDto userDto) {
        return sysUserService.getList(userDto);
//        return ResultResponse.success();
    }

    @PostMapping("/login")
    public ResultResponse login(@RequestBody SysUser user) {
        try {
//            Subject subject = SecurityUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), "1024");
//            subject.login(token);
            sysUserService.selectByUserName(user.getUsername());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultResponse.error(e.getMessage());
        }
        return ResultResponse.success();
    }
}
