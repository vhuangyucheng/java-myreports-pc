package com.solar4america.DO;

import lombok.Data;

import java.util.List;

@Data
public class ELQO {
    private String id ;
    private String shift;
    private String type;
    List<Defect> defect;
}
