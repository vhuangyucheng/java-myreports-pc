package com.solar4america.test;


import com.solar4america.entity.RecordsDBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


public class Test {
    public static void main(String[] args) {
        RecordsDBO recordsDBO1 = new RecordsDBO();
        recordsDBO1.setShiftId(1);
        RecordsDBO recordsDBO2 = new RecordsDBO();
        recordsDBO2.setShiftId(2);
        recordsDBO2.setIsLock(2);
//        BeanUtils.copyProperties(recordsDBO1, recordsDBO2, getNullPropertyNames(recordsDBO1));
        System.out.println(recordsDBO1);
        System.out.println(recordsDBO2);
    }


}
