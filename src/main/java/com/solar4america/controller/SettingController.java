package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.entity.SettingDBO;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.service.setting.api.ISettingApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    public ISettingApi settingApi;

    @PostMapping("/getSetting")
    public ResultDO<SettingDBO> getSetting() {
        ResultDO<SettingDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        SettingDBO settingDBO = settingApi.getSetting();
        if (null == settingDBO) {
            return resultDO;
        }
        resultDO.setData(settingDBO);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/setSetting")
    public ResultDO<Object> setSetting(@RequestBody SettingDBO settingDBO) {
        ResultDO<Object> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        settingApi.setSetting(settingDBO);
        resultDO.setCode("1");
        return resultDO;
    }

}
