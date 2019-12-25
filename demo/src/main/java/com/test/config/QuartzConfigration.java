package com.test.config;

import com.test.entity.QuartzDto;
import com.test.quartz.TestQuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * 练习quartz定时任务
 */
@Configuration
@Slf4j
public class QuartzConfigration {

    @Autowired
    private Scheduler scheduler;

    /**
     * 调用这个方法， 开启定时任务
     * @param quartzDto
     * @throws SchedulerException
     */
    public void startJob(QuartzDto quartzDto) throws SchedulerException {
        createStartJob(scheduler, quartzDto);
        scheduler.start();
    }

    private void createStartJob(Scheduler scheduler, QuartzDto quartzDto) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(TestQuartzJob.class).withIdentity(quartzDto.getName(), quartzDto.getGroup()).build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzDto.getCron());
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(quartzDto.getName(), quartzDto.getGroup()).withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 删除定时任务
     */
    public void deleteJob(QuartzDto quartzDto) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzDto.getName(), quartzDto.getGroup());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.deleteJob(jobKey);
        log.info("---------------删除任务");
    }

    /**
     * 获取Job信息
     * @return
     * @throws SchedulerException
     */
    public String getJobInfo(QuartzDto quartzDto) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(quartzDto.getName(), quartzDto.getGroup());
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name());
    }

    /**
     * 修改某个任务的执行时间
     * @return
     * @throws SchedulerException
     */
    public boolean modifyJob(QuartzDto quartzDto) throws SchedulerException {
        Date date = null;
        TriggerKey triggerKey = new TriggerKey(quartzDto.getName(), quartzDto.getGroup());
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldTime = cronTrigger.getCronExpression();
        if (!oldTime.equalsIgnoreCase(quartzDto.getCron())) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzDto.getCron());
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzDto.getName(), quartzDto.getGroup())
                    .withSchedule(cronScheduleBuilder).build();
            date = scheduler.rescheduleJob(triggerKey, trigger);
        }
        return date != null;
    }

    /**
     * 暂停所有任务
     *
     * @throws SchedulerException
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     *
     * @throws SchedulerException
     */
    public void pauseJob(QuartzDto quartzDto) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzDto.getName(), quartzDto.getGroup());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复所有任务
     *
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     *
     * @throws SchedulerException
     */
    public void resumeJob(QuartzDto quartzDto) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzDto.getName(), quartzDto.getGroup());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.resumeJob(jobKey);
    }
}
