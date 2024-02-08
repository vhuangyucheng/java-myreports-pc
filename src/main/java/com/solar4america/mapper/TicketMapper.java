package com.solar4america.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.entity.TicketDBO;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMapper extends BaseMapper<TicketDBO> {
}

