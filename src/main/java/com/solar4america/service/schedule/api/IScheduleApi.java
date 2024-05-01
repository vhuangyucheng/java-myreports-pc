package com.solar4america.service.schedule.api;

import com.solar4america.entity.ScheduleDBO;

public interface IScheduleApi {
    public ScheduleDBO getSchedule();
    public void setSchedule(ScheduleDBO scheduleDBO);
}
