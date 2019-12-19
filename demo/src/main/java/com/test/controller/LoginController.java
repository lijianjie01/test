package com.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
//@RequestMapping(value = "/")
public class LoginController {

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public Map<String, Object> login(Map map) {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken();
//        subject.login(token);
//    }
}
