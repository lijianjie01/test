package com.test.controller;

import com.test.entity.SysUser;
import com.test.entity.User;
import com.test.utils.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/doLogin")
public class LoginController {

    @PostMapping("/login")
    public ResultResponse login(@RequestBody SysUser user) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), "1024");
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultResponse.error(e.getMessage());
        }
        return ResultResponse.success();
    }

    @RequestMapping("/loginPage")
    public String login() {
        return "loginPage, please login!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
