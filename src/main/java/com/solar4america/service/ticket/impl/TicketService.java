package com.solar4america.service.ticket.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.solar4america.entity.TicketDBO;
import com.solar4america.mapper.TicketMapper;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.mapper.ShiftRecordMapper;
import com.solar4america.service.ticket.api.ITicketApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class TicketService implements ITicketApi {
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<TicketDBO> listRecords(TicketDBO ticketDBO) {
        QueryWrapper<TicketDBO> queryWrapper  = new QueryWrapper<>();
        if(ticketDBO.getTicketStatus()!=0){
            queryWrapper.eq("ticket_status", ticketDBO.getTicketStatus());
        }
        if(ticketDBO.getTicketDuration()!=0){
            queryWrapper.eq("ticket_duration", ticketDBO.getTicketDuration());
        }
        queryWrapper.orderByAsc("create_time");
        return ticketMapper.selectList(queryWrapper);
    }

    @Override
    public int saveAndEditTicket(TicketDBO ticketDBO) {
        QueryWrapper<TicketDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("ticket_id", ticketDBO.getTicketId());
        TicketDBO ticketDBOTemp= ticketMapper.selectOne(queryWrapper);
        if(null == ticketDBOTemp){
            ticketMapper.insert(ticketDBO);
            return 1;
        }
        BeanUtils.copyProperties(ticketDBO, ticketDBOTemp, getNullPropertyNames(ticketDBO));
        ticketMapper.updateById(ticketDBOTemp);
        return 1;
    }

    @Override
    public TicketDBO getTicket(TicketDBO ticketDBO) {
        return null;
    }

    public static String[] getNullPropertyNames(Object source) {
//        org.springframework.beans.BeanWrapper
        final BeanWrapper src = new BeanWrapperImpl(source);
//        java.beans.PropertyDescriptor
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
