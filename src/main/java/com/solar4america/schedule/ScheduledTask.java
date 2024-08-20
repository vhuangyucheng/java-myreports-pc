package com.solar4america.schedule;

import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.stringerClient.Line2;
import com.solar4america.uiltility.Leftover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduledTask {
    @Autowired
    public IShiftRecordApi shiftRecordApi;

    @Autowired
    public Leftover leftover;

    @Scheduled(cron = "0 58 23 * * *")
//    @Scheduled(cron = "0 0 16 * * *")
    public void performTask() {
        leftover.ServiceExecute();
        log.info("Leftover execute");
    }
    //切换shift
//    @Scheduled(cron = "0 45 6 * * ?")
//    public void changeToFirstShift() {
//
//        Line2.getInstance().empty();
//        Line2.getInstance().getStringer21().setCurrentShift(1);
//        Line2.getInstance().getStringer22().setCurrentShift(1);
//        Line2.getInstance().getStringer23().setCurrentShift(1);
//        log.info("执行shift change时间 6:45 ：" + LocalDateTime.now());
//    }
//
//    @Scheduled(cron = "0 15 15 * * ?")
//    public void ChangeToSecondShift() {
//        Line2.getInstance().getStringer21().setCurrentShift(2);
//        Line2.getInstance().getStringer22().setCurrentShift(2);
//        Line2.getInstance().getStringer23().setCurrentShift(2);
//        log.info("执行shift change时间 15:15 ：" + LocalDateTime.now());
//    }
//
//    @Scheduled(cron = "0 30 23 * * ?")
//    public void ChangeToThirdShift() {
//        Line2.getInstance().getStringer21().setCurrentShift(3);
//        Line2.getInstance().getStringer22().setCurrentShift(3);
//        Line2.getInstance().getStringer23().setCurrentShift(3);
//        log.info("执行shift change时间 23:30 ：" + LocalDateTime.now());
//    }

    //shift结束发送数据
//    @Scheduled(cron = "0 44 6 * * ?")
//    public void thirdShiftFinish() {
//        int Stringer21Amount = Line2.getInstance().getStringer21().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer21().getCurrentShift().getOKStringB();
//        int Stringer22Amount = Line2.getInstance().getStringer22().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer22().getCurrentShift().getOKStringB();
//        int Stringer23Amount = Line2.getInstance().getStringer23().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer23().getCurrentShift().getOKStringB();
//        ShiftRecordDBO shiftRecordDBO = new ShiftRecordDBO();
//        shiftRecordDBO.setStringer1Output(Stringer21Amount);
//        shiftRecordDBO.setStringer2Output(Stringer22Amount);
//        shiftRecordDBO.setStringer3Output(Stringer23Amount);
//        LocalDate date = LocalDate.now();
//        // Format the date as "yyyyMMdd"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        int dateNumber = Integer.parseInt(date.format(formatter)+"23")-100;
//        shiftRecordDBO.setShiftId(dateNumber);
////        shiftRecordApi.saveAndEditShiftRecord(shiftRecordDBO);
//        log.info("third shift data collect 时间 6:44 ：" + LocalDateTime.now());
//    }
//
//    @Scheduled(cron = "0 14 15 * * ?")
//    public void firstShiftFinish() {
//        int Stringer21Amount = Line2.getInstance().getStringer21().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer21().getCurrentShift().getOKStringB();
//        int Stringer22Amount = Line2.getInstance().getStringer22().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer22().getCurrentShift().getOKStringB();
//        int Stringer23Amount = Line2.getInstance().getStringer23().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer23().getCurrentShift().getOKStringB();
//        ShiftRecordDBO shiftRecordDBO = new ShiftRecordDBO();
//        shiftRecordDBO.setStringer1Output(Stringer21Amount);
//        shiftRecordDBO.setStringer2Output(Stringer22Amount);
//        shiftRecordDBO.setStringer3Output(Stringer23Amount);
//        LocalDate date = LocalDate.now();
//        // Format the date as "yyyyMMdd"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        int dateNumber = Integer.parseInt(date.format(formatter)+"21");
//        shiftRecordDBO.setShiftId(dateNumber);
////        shiftRecordApi.saveAndEditShiftRecord(shiftRecordDBO);
//        log.info("firstShiftFinish 15:14 ：" + LocalDateTime.now());
//    }
//
//    @Scheduled(cron = "0 29 23 * * ?")
//    public void secondShiftFinish() {
//        int Stringer21Amount = Line2.getInstance().getStringer21().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer21().getCurrentShift().getOKStringB();
//        int Stringer22Amount = Line2.getInstance().getStringer22().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer22().getCurrentShift().getOKStringB();
//        int Stringer23Amount = Line2.getInstance().getStringer23().getCurrentShift().getOKStringA() + Line2.getInstance().getStringer23().getCurrentShift().getOKStringB();
//        ShiftRecordDBO shiftRecordDBO = new ShiftRecordDBO();
//        shiftRecordDBO.setStringer1Output(Stringer21Amount);
//        shiftRecordDBO.setStringer2Output(Stringer22Amount);
//        shiftRecordDBO.setStringer3Output(Stringer23Amount);
//        LocalDate date = LocalDate.now();
//        // Format the date as "yyyyMMdd"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        int dateNumber = Integer.parseInt(date.format(formatter)+"22");
//        shiftRecordDBO.setShiftId(dateNumber);
////        shiftRecordApi.saveAndEditShiftRecord(shiftRecordDBO);
//        log.info("secondShiftFinish 23:29 ：" + LocalDateTime.now());
//    }


}

