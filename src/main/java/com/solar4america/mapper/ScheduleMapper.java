package com.solar4america.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solar4america.entity.ScheduleDBO;
import com.solar4america.entity.ShiftRecordDBO;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleMapper extends BaseMapper<ScheduleDBO> {
}
