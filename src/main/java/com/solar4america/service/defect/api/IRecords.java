package com.solar4america.service.defect.api;

import com.solar4america.entity.RecordsDBO;

import java.util.List;

public interface IRecords {
    public List<RecordsDBO> listRecords(Integer shiftId);
    public int saveAndEditRecord(RecordsDBO recordsDBO);

    public RecordsDBO getRecord(Integer shiftId);
}
