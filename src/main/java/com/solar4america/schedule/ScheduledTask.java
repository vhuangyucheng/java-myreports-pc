package com.solar4america.schedule;

import com.solar4america.stringerClient.Line2;
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

    @Scheduled(cron="0 45 6 * * ?")
    public void changeToFirstShift() {
        Line2.getInstance().getStringer21().setCurrentShift(1);
        Line2.getInstance().getStringer22().setCurrentShift(1);
        Line2.getInstance().getStringer23().setCurrentShift(1);
        log.info("任务执行时间：" + LocalDateTime.now());
    }

    @Scheduled(cron="0 15 15 * * ?")
    public void ChangeToSecondShift() {
        Line2.getInstance().getStringer21().setCurrentShift(2);
        Line2.getInstance().getStringer22().setCurrentShift(2);
        Line2.getInstance().getStringer23().setCurrentShift(2);
        log.info("任务执行时间：" + LocalDateTime.now());
    }

    @Scheduled(cron="0 30 23 * * ?")
    public void ChangeToThirdShift() {
        Line2.getInstance().getStringer21().setCurrentShift(3);
        Line2.getInstance().getStringer22().setCurrentShift(3);
        Line2.getInstance().getStringer23().setCurrentShift(3);
        log.info("任务执行时间：" + LocalDateTime.now());
    }

}

