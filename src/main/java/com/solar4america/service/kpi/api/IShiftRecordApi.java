package com.solar4america.service.kpi.api;

import com.solar4america.entity.ShiftRecordDBO;

import java.util.List;

public interface IShiftRecordApi {
    public List<ShiftRecordDBO> listRecords(ShiftRecordDBO shiftRecordDBO);
    public int saveAndEditShiftRecord(ShiftRecordDBO shiftRecordDBO);

    void unlockByDate(Integer shiftId);

    public ShiftRecordDBO getRecord(Integer shiftId);
}
