package com.test.controller;

import com.test.entity.SysUser;
import com.test.security.JwtAuthenticatioToken;
import com.test.service.SysUserService;
import com.test.utils.ResultResponse;
import com.test.utils.SecurityUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "登录相关接口")
@Slf4j
//@RequestMapping("/doLogin")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResultResponse login(@RequestBody SysUser user, HttpServletRequest request) {
        try {
//            Subject subject = SecurityUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), "1024");
//            subject.login(token);
//            JwtAuthenticatioToken token = SecurityUtils.login(request, user.getUsername(), user.getPassword(), authenticationManager);
            sysUserService.selectByUserName(user.getUsername());
            return ResultResponse.success();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultResponse.error(e.getMessage());
        }
    }

    @GetMapping("/loginPage")
    public String login() {
        return "loginPage, please login!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
