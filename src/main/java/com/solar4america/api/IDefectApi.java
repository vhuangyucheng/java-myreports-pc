package com.solar4america.api;

import com.solar4america.entity.DefectDBO;
import com.solar4america.entity.RecordsDBO;
import com.solar4america.entity.ShiftRecordDBO;

public interface IDefectApi {
    public int saveAndEditShiftRecord(DefectDBO defectDBO);

    public DefectDBO getRecord(String qrcode);
}
