package com.test.controller;

import com.test.config.QuartzConfigration;
import com.test.entity.QuartzDto;
import com.test.service.QuartzTaskService;
import com.test.utils.ResultResponse;
import org.quartz.SchedulerException;
import org.quartz.ee.jmx.jboss.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private QuartzTaskService quartzTaskService;

    @PostMapping("/startJob")
    public ResultResponse startJob(@RequestBody QuartzDto quartzDto) {
        try {
            return quartzTaskService.startJob(quartzDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.error(e.getMessage());
        }
    }

    @PostMapping("/deleteJob")
    public ResultResponse deleteJob(@RequestBody QuartzDto quartzDto) {
        try {
            return quartzTaskService.deleteJob(quartzDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.error(e.getMessage());
        }
    }
}
