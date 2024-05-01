package com.solar4america.service.schedule.impl;

import com.solar4america.entity.ScheduleDBO;
import com.solar4america.mapper.ScheduleMapper;
import com.solar4america.mapper.ShiftRecordMapper;
import com.solar4america.service.schedule.api.IScheduleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduleService implements IScheduleApi {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDBO getSchedule() {
        return scheduleMapper.selectById(1);
    }

    @Override
    public void setSchedule(ScheduleDBO scheduleDBO) {
        scheduleMapper.updateById(scheduleDBO);
    }
}
