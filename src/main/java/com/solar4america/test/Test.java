package com.solar4america.test;


import com.solar4america.entity.RecordsDBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Test {
    public static void main(String[] args) {


        // Parse the input date
        LocalDate date = LocalDate.now();

        // Format the date as "yyyyMMdd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = date.format(formatter);

        // Print the formatted date
        System.out.println("Formatted Date: " + formattedDate);
    }


}
