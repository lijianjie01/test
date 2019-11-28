package com.test.controller;

import com.test.mail.SendMailTest;
import com.test.utils.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试swagger")
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private SendMailTest sendMailTest;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation("返回测试数据")
    public String helloDemo() {
        return "Hello demo";
    }

    @RequestMapping(value = "/testSendMail", method = RequestMethod.GET)
    @ApiOperation("测试返回邮件")
    public ResultResponse testSendMail() {
        log.info("测试发送邮件开始~~~~~~~~~~~~~~~");
        sendMailTest.sendMail();
        log.info("测试发送邮件结束~~~~~~~~~~~~~~~");
        return ResultResponse.success();
    }
}
