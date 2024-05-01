package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.entity.DefectDBO;
import com.solar4america.entity.ScheduleDBO;
import com.solar4america.service.defect.api.IDefectApi;
import com.solar4america.service.schedule.api.IScheduleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    public IScheduleApi scheduleApi;

    @PostMapping("/getSchedule")
    public ResultDO<ScheduleDBO> getSchedule() {
        ResultDO<ScheduleDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        ScheduleDBO scheduleDBO = scheduleApi.getSchedule();
        resultDO.setCode("1");
        resultDO.setData(scheduleDBO);
        return resultDO;
    }

    @PostMapping("/setSchedule")
    public ResultDO<Object> setSchedule(@RequestBody ScheduleDBO scheduleDBO) {
        ResultDO<Object> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        scheduleApi.setSchedule(scheduleDBO);
        resultDO.setCode("1");
        resultDO.setData(null);
        return resultDO;
    }
}