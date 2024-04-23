package com.solar4america.controller;

import com.solar4america.DO.response.ResultDO;
import com.solar4america.entity.TicketDBO;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.service.ticket.api.ITicketApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    public ITicketApi ticketApi;

    @PostMapping("/getTicket")
    public ResultDO<TicketDBO> getShiftRecord(@RequestBody TicketDBO ticketDBO) {
        ResultDO<TicketDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        if (null == ticketDBO.getTicketId()) {
            return resultDO;
        }
        TicketDBO ticketDBOReturn = ticketApi.getTicket(ticketDBO.getTicketId());
        if (null == ticketDBOReturn) {
            return resultDO;
        }
        resultDO.setData(ticketDBOReturn);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/listTicket")
    public ResultDO<List<TicketDBO>> listShiftRecord(@RequestBody TicketDBO ticketDBO) {
        ResultDO<List<TicketDBO>> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        List<TicketDBO> ticketDBOList = ticketApi.listRecords(ticketDBO);
        if (null == ticketDBOList || ticketDBOList.isEmpty()) {
            return resultDO;
        }
        resultDO.setData(ticketDBOList);
        resultDO.setCode("1");
        return resultDO;
    }

    @PostMapping("/saveAndUpdate")
    public ResultDO<ShiftRecordDBO> saveAndUpdate(@RequestBody TicketDBO ticketDBO) {
        ResultDO<ShiftRecordDBO> resultDO = new ResultDO<>();
        resultDO.setData(null);
        resultDO.setCode("0");
        int result = ticketApi.saveAndEditTicket(ticketDBO);
        if(0 == result){
            return resultDO;
        }
        resultDO.setCode("1");
        return resultDO;
    }


}
