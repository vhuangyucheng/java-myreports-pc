package com.solar4america.service.defect.api;

import com.solar4america.entity.DefectDBO;

import java.util.List;

public interface IDefectApi {
    public int saveAndEditShiftRecord(DefectDBO defectDBO);

    public DefectDBO getRecord(String qrcode);
    public List<DefectDBO> ListOpenReview();
}
