package com.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试swagger")
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/")
    @ApiOperation("返回测试数据")
    public String helloDemo() {
        return "Hello demo";
    }
}
