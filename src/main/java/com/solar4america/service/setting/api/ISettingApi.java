package com.solar4america.service.setting.api;

import com.solar4america.entity.SettingDBO;
import com.solar4america.entity.WoDBO;

import java.util.List;

public interface ISettingApi {
    public SettingDBO getSetting();

    public void setSetting(SettingDBO settingDBO);

    public List<WoDBO> listWo();
}
