package com.solar4america.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.solar4america.api.IRecords;
import com.solar4america.entity.RecordsDBO;
import com.solar4america.mapper.RecordsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecordService implements IRecords {

    @Autowired
    private RecordsMapper recordsMapper;

    //列表
    @Override
    public List<RecordsDBO> listRecords() {
        return null;
    }

    //保存和修改
    @Override
    public void saveRecord(RecordsDBO recordsDBO) {
        recordsDBO = getRecord(recordsDBO.getShiftId());
    }

    @Override
    public RecordsDBO getRecord(Integer shiftId) {
        QueryWrapper<RecordsDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("shift_id", shiftId);
        return recordsMapper.selectOne(queryWrapper);
    }

}
