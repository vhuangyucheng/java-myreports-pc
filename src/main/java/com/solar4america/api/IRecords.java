package com.solar4america.api;

import com.solar4america.entity.RecordsDBO;

import java.util.List;

public interface IRecords {
    public List<RecordsDBO> listRecords();
    public void saveRecord(RecordsDBO recordsDBO);

    public RecordsDBO getRecord(Integer shiftId);
}
