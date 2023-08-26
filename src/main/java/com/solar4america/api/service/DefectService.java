package com.solar4america.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.solar4america.api.IDefectApi;
import com.solar4america.api.IShiftRecordApi;
import com.solar4america.entity.DefectDBO;
import com.solar4america.entity.RecordsDBO;
import com.solar4america.entity.ShiftRecordDBO;
import com.solar4america.mapper.DefectMapper;
import com.solar4america.mapper.ShiftRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service
public class DefectService implements IDefectApi {
    @Autowired
    private DefectMapper defectMapper;

    @Override
    public int saveAndEditShiftRecord(DefectDBO defectDBO) {
        DefectDBO defectDBOTemp = null;
        if (defectDBO.getDefectId() != null) {
            defectDBOTemp = defectMapper.selectById(defectDBO.getDefectId());
        } else {
            QueryWrapper<DefectDBO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("qrcode", defectDBO.getQrcode());
            queryWrapper.eq("shift_location", defectDBO.getShiftLocation());
            queryWrapper.eq("station", defectDBO.getReason());
            defectDBOTemp = defectMapper.selectOne(queryWrapper);
        }

        if (null == defectDBOTemp) {
            defectMapper.insert(defectDBO);
            return 1;
        }
        BeanUtils.copyProperties(defectDBO, defectDBOTemp, getNullPropertyNames(defectDBO));
        defectMapper.updateById(defectDBOTemp);
        return 1;
    }

    @Override
    public DefectDBO getRecord(String qrcode) {
        QueryWrapper<DefectDBO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("qrcode", qrcode);
        queryWrapper.ne("status", 0);
        return defectMapper.selectOne(queryWrapper);
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