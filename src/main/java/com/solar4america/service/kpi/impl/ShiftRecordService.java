package com.solar4america.service.kpi.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.solar4america.service.kpi.api.IShiftRecordApi;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.mapper.ShiftRecordMapper;
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
public class ShiftRecordService implements IShiftRecordApi {
    @Autowired
    private ShiftRecordMapper shiftRecordMapper;

    @Override
    public List<ShiftRecordDBO> listRecords(ShiftRecordDBO shiftRecordDBO) {
        QueryWrapper<ShiftRecordDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("is_lock", shiftRecordDBO.getIsLock());
        queryWrapper.gt("shift_id", shiftRecordDBO.getShiftId());
        queryWrapper.lt("shift_id", shiftRecordDBO.getShiftId()+100);
        queryWrapper.orderByAsc("shift_id");
        return shiftRecordMapper.selectList(queryWrapper);
    }

    @Override
    synchronized public int saveAndEditShiftRecord(ShiftRecordDBO shiftRecordDBO) {
        QueryWrapper<ShiftRecordDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("shift_id", shiftRecordDBO.getShiftId());
        ShiftRecordDBO recordsDBOTemp= shiftRecordMapper.selectOne(queryWrapper);
        if(null == recordsDBOTemp){
            shiftRecordDBO.setIsLock(0);
            shiftRecordMapper.insert(shiftRecordDBO);
            return 1;
        }
        if(1 == recordsDBOTemp.getIsLock()){
            return 0;
        }
        BeanUtils.copyProperties(shiftRecordDBO, recordsDBOTemp, getNullPropertyNames(shiftRecordDBO));
        shiftRecordMapper.updateById(recordsDBOTemp);
        return 1;
    }

    @Override
    public void unlockByDate(Integer shiftId) {
        // Create an instance of UpdateWrapper
        UpdateWrapper<ShiftRecordDBO> updateWrapper = new UpdateWrapper<>();

        // Set the condition for the update
        updateWrapper.eq("shift_id", shiftId);

        // Set the update statement
        updateWrapper.set("is_lock", 0);

        // Perform the update
        shiftRecordMapper.update(null, updateWrapper);
    }

    @Override
    public ShiftRecordDBO getRecord(Integer shiftId) {
        QueryWrapper<ShiftRecordDBO> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("shift_id", shiftId);
        return shiftRecordMapper.selectOne(queryWrapper);
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
