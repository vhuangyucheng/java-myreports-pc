package com.solar4america.service.setting.impl;

import com.solar4america.entity.ScheduleDBO;
import com.solar4america.entity.SettingDBO;
import com.solar4america.mapper.ScheduleMapper;
import com.solar4america.mapper.SettingMapper;
import com.solar4america.service.schedule.api.IScheduleApi;
import com.solar4america.service.setting.api.ISettingApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SettingService implements ISettingApi {
    @Autowired
    private SettingMapper settingMapper;

    @Override
    public SettingDBO getSetting() {
        return settingMapper.selectById(1);
    }

    @Override
    public void setSetting(SettingDBO settingDBO) {
        settingDBO.setSettingId(1);
        settingMapper.updateById(settingDBO);
    }
}
