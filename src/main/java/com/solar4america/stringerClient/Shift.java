package com.solar4america.stringerClient;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Shift implements Serializable {
    @NonNull
    private String shiftName;

    private Integer OKStringA = 0;
    private Integer OKStringB = 0;
    private Integer NGStringA = 0;
    private Integer NGStringB = 0;
    private Integer NGCellA = 0;
    private Integer NGCellB = 0;
    //故障时间
    private Integer errorTImeA = 0;
    private Integer errorTImeB = 0;
    //缺料时间
    private Integer lackTimeA = 0;
    private Integer lackTimeB = 0;
    //手动时间
    private Integer ManualRunTimeA = 0;
    private Integer ManualRunTimeB = 0;
    //自动运行时间
    private Integer autoRunTimeA = 0;
    private Integer autoRunTimeB = 0;
    //自动暂停时间
    private Integer PauseTimeA = 0;
    private Integer PauseTimeB = 0;
    //堵料时间
    private Integer blockTimeA = 0;
    private Integer blockTimeB = 0;
}
