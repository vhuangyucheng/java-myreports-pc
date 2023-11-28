package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.exception.BaseServiceException;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/wip")
public class WIPMaterialController {

    @PostMapping("/getWip")
    public ResultDO<Object> getWip(@RequestBody ShiftRecordDBO shiftRecordDBO) {
        ResultDO<Object> resultDO = new ResultDO<>();
        resultDO.setCode("1");
        resultDO.setMessage("dd");
        if(shiftRecordDBO.getIsLock() == 1){
            throw new BaseServiceException("0", "222");
        }
        return resultDO;
    }
}