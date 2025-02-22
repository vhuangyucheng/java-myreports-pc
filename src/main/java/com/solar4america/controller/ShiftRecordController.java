package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.entity.ShiftRecordDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/listShiftRecordByWo")
    public ResultDO<List<ShiftRecordDBO>> listShiftRecordByWo(@RequestBody ShiftRecordDBO shiftRecordDBO) {
        ResultDO<List<ShiftRecordDBO>> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        List<ShiftRecordDBO> recordsDBOList = shiftRecordApi.listRecordsByWo(shiftRecordDBO);
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

    @GetMapping("/unlock/{id}")
    public ResultDO<Object> unlock(@PathVariable Integer id) {
        System.out.println(id);
        shiftRecordApi.unlockByDate(id);
        ResultDO<Object> resultDO = new ResultDO<>();
        resultDO.setCode("1");
        return resultDO;
    }
}
