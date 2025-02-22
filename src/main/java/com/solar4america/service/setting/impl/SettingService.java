package com.solar4america.service.setting.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.solar4america.entity.SettingDBO;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.entity.WoDBO;
import com.solar4america.mapper.SettingMapper;
import com.solar4america.mapper.WoMapper;
import com.solar4america.service.setting.api.ISettingApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class SettingService implements ISettingApi {
    @Autowired
    private SettingMapper settingMapper;
    @Autowired
    private WoMapper woMapper;


    @Override
    public SettingDBO getSetting() {
        return settingMapper.selectById(1);
    }

    @Override
    public void setSetting(SettingDBO settingDBO) {
        settingDBO.setSettingId(1);
        settingMapper.updateById(settingDBO);
    }

    @Override
    public List<WoDBO> listWo() {
        List<WoDBO> woDBOList  = woMapper.selectList(null);
        return woDBOList;
    }


}
