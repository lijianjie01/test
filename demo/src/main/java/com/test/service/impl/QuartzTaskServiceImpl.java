package com.test.service.impl;

import com.test.config.QuartzConfigration;
import com.test.entity.QuartzDto;
import com.test.service.QuartzTaskService;
import com.test.utils.ResultResponse;
import org.apache.commons.lang3.StringUtils;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzTaskServiceImpl implements QuartzTaskService {

    @Autowired
    private QuartzConfigration quartzConfigration;

    @Override
    public ResultResponse startJob(QuartzDto quartzDto) throws SchedulerException {
        if (!StringUtils.isNotEmpty(quartzDto.getName())) {
            return ResultResponse.error("name为空");
        } else if (!StringUtils.isNotEmpty(quartzDto.getGroup())) {
            return ResultResponse.error("group为空");
        } else if (!StringUtils.isNotEmpty(quartzDto.getCron())) {
            return ResultResponse.error("cron为空");
        }
        quartzConfigration.startJob(quartzDto);
        return ResultResponse.success();
    }

    @Override
    public ResultResponse deleteJob(QuartzDto quartzDto) throws SchedulerException {
        if (!StringUtils.isNotEmpty(quartzDto.getName())) {
            return ResultResponse.error("name为空");
        } else if (!StringUtils.isNotEmpty(quartzDto.getGroup())) {
            return ResultResponse.error("group为空");
        }
        quartzConfigration.deleteJob(quartzDto);
        return ResultResponse.success();
    }
}
