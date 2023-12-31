package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.service.defect.api.IRecords;
import com.solar4america.entity.RecordsDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    public IRecords recordsApi;

    @PostMapping("/getRecord")
    public ResultDO<RecordsDBO> getRecord(@RequestBody RecordsDBO recordsDBO) {
        ResultDO<RecordsDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        if (null == recordsDBO.getShiftId()) {
            return resultDO;
        }
        RecordsDBO recordsDBOReturn = recordsApi.getRecord(recordsDBO.getShiftId());
        if (null == recordsDBOReturn) {
            return resultDO;
        }
        resultDO.setData(recordsDBOReturn);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/listRecord")
    public ResultDO<List<RecordsDBO>> listRecord(@RequestBody RecordsDBO recordsDBO) {
        ResultDO<List<RecordsDBO>> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        if (null == recordsDBO.getShiftId()) {
            return resultDO;
        }
        List<RecordsDBO> recordsDBOList = recordsApi.listRecords(recordsDBO.getShiftId());
        if (null == recordsDBOList || recordsDBOList.isEmpty()) {
            return resultDO;
        }
        resultDO.setData(recordsDBOList);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/saveAndUpdate")
    public ResultDO<RecordsDBO> saveAndUpdate(@RequestBody RecordsDBO recordsDBO) {
        ResultDO<RecordsDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        int result = recordsApi.saveAndEditRecord(recordsDBO);
        if(0 == result){
            return resultDO;
        }
        resultDO.setCode("1");
        return resultDO;
    }
}
