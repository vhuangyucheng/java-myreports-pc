package com.solar4america.service.setting.api;

import com.solar4america.entity.SettingDBO;

public interface ISettingApi {
    public SettingDBO getSetting();
    public void setSetting(SettingDBO settingDBO);


}
