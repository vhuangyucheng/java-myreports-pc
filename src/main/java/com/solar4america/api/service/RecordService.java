package com.solar4america.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.solar4america.api.IRecords;
import com.solar4america.entity.RecordsDBO;
import com.solar4america.mapper.RecordsMapper;
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
public class RecordService implements IRecords {

    @Autowired
    private RecordsMapper recordsMapper;

    //列表
    @Override
    public List<RecordsDBO> listRecords(Integer shiftId) {
        QueryWrapper<RecordsDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.gt("shift_id", shiftId);
        queryWrapper.lt("shift_id", shiftId+100);
        return recordsMapper.selectList(queryWrapper);
    }

    //保存和修改
    @Override
    public void saveAndEditRecord(RecordsDBO recordsDBO) {
        QueryWrapper<RecordsDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("shift_id", recordsDBO.getShiftId());
        RecordsDBO recordsDBOTemp= recordsMapper.selectOne(queryWrapper);
        if(null == recordsDBOTemp){
            recordsMapper.insert(recordsDBO);
            return;
        }
        BeanUtils.copyProperties(recordsDBO, recordsDBOTemp, getNullPropertyNames(recordsDBO));
        recordsMapper.updateById(recordsDBOTemp);
    }


    @Override
    public RecordsDBO getRecord(Integer shiftId) {
        QueryWrapper<RecordsDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("shift_id", shiftId);
        return recordsMapper.selectOne(queryWrapper);
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
