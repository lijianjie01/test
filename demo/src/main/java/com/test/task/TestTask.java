package com.test.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 整合定时任务
 */
//@Component // 注解扫描到才会执行此定时任务
@Slf4j // log 日志
public class TestTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void printNow() {
        log.info("===========> fixedRate方式执行定时任务 {}",new Date());
        System.out.println("现在时间是： ---" + sdf.format(new Date()));
    }
}
