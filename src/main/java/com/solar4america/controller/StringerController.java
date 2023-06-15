package com.solar4america.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Stringer")
public class StringerController {

    //0全部，1坏的


    @PostMapping("/test")
    public String listMachine() {
        return "test";
    }
}
