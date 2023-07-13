package com.solar4america.schedule;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduledTask {

    @Scheduled(cron="0 5 16 * * ?")
    public void scheduledTask() {
        System.out.println("任务执行时间：" + LocalDateTime.now());
        log.info("任务执行时间：" + LocalDateTime.now());
    }

    //todo 开机任务
    //todo 三个班的间隙任务
    //todo 切换班别定时任务
}

