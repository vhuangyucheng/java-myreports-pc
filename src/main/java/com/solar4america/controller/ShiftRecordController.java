package com.solar4america.controller;

import com.solar4america.DO.ResultDO;
import com.solar4america.api.IRecords;
import com.solar4america.api.IShiftRecordApi;
import com.solar4america.entity.RecordsDBO;
import com.solar4america.entity.ShiftRecordDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shiftRecord")
public class ShiftRecordController {

    @Autowired
    public IShiftRecordApi shiftRecordApi;

    @PostMapping("/getShiftRecord")
    public ResultDO<ShiftRecordDBO> getShiftRecord(@RequestBody ShiftRecordDBO shiftRecordDBO) {
        ResultDO<ShiftRecordDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        if (null == shiftRecordDBO.getShiftId()) {
            return resultDO;
        }
        ShiftRecordDBO recordsDBOReturn = shiftRecordApi.getRecord(shiftRecordDBO.getShiftId());
        if (null == recordsDBOReturn) {
            return resultDO;
        }
        resultDO.setData(recordsDBOReturn);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/listShiftRecord")
    public ResultDO<List<ShiftRecordDBO>> listShiftRecord(@RequestBody ShiftRecordDBO shiftRecordDBO) {
        ResultDO<List<ShiftRecordDBO>> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        if (null == shiftRecordDBO.getShiftId()) {
            return resultDO;
        }
        List<ShiftRecordDBO> recordsDBOList = shiftRecordApi.listRecords(shiftRecordDBO);
        if (null == recordsDBOList || recordsDBOList.isEmpty()) {
            return resultDO;
        }
        resultDO.setData(recordsDBOList);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/saveAndUpdate")
    public ResultDO<ShiftRecordDBO> saveAndUpdate(@RequestBody ShiftRecordDBO shiftRecordDBO) {
        ResultDO<ShiftRecordDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        int result = shiftRecordApi.saveAndEditShiftRecord(shiftRecordDBO);
        if(0 == result){
            return resultDO;
        }
        resultDO.setCode("1");
        return resultDO;
    }
}
