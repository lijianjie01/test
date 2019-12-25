package com.test.service;

import com.test.entity.QuartzDto;
import com.test.utils.ResultResponse;
import org.quartz.SchedulerException;

public interface QuartzTaskService {
    ResultResponse startJob(QuartzDto quartzDto) throws SchedulerException;

    ResultResponse deleteJob(QuartzDto quartzDto) throws SchedulerException;
}
