package com.solar4america.api;

import com.solar4america.entity.RecordsDBO;
import com.solar4america.entity.ShiftRecordDBO;

import java.util.List;

public interface IShiftRecordApi {
    public List<ShiftRecordDBO> listRecords(ShiftRecordDBO shiftRecordDBO);
    public int saveAndEditShiftRecord(ShiftRecordDBO shiftRecordDBO);

    public ShiftRecordDBO getRecord(Integer shiftId);
}
