package com.solar4america.controller;

import com.solar4america.DO.ResultDO;
import com.solar4america.api.IDefectApi;
import com.solar4america.api.IShiftRecordApi;
import com.solar4america.entity.DefectDBO;
import com.solar4america.entity.ShiftRecordDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/Defect")
public class DefectController {

    @Autowired
    public IDefectApi defectApi;

    @PostMapping("/getDefect")
    public ResultDO<DefectDBO> getDefect(@RequestBody DefectDBO defectDBO) {
        ResultDO<DefectDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        DefectDBO defectDBOReturn  = defectApi.getRecord(defectDBO.getQrcode());
        if(null == defectDBOReturn){
            return resultDO;
        }
        resultDO.setCode("1");
        resultDO.setData(defectDBOReturn);
        return resultDO;
    }

    @PostMapping("/saveAndUpdate")
    public ResultDO<DefectDBO> saveAndUpdate(@RequestBody DefectDBO defectDBO) {
        ResultDO<DefectDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        int result = defectApi.saveAndEditShiftRecord(defectDBO);
        if(0 == result){
            return resultDO;
        }
        resultDO.setCode("1");
        return resultDO;
    }
}