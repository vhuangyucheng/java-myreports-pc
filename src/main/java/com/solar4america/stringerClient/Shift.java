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
    private Double errorTImeA = 0.0;
    private Double errorTImeB = 0.0;
    //缺料时间
    private Double lackTimeA = 0.0;
    private Double lackTimeB = 0.0;
    //手动时间
    private Double ManualRunTimeA = 0.0;
    private Double ManualRunTimeB = 0.0;
    //自动运行时间
    private Double autoRunTimeA = 0.0;
    private Double autoRunTimeB = 0.0;
    //自动暂停时间
    private Double PauseTimeA = 0.0;
    private Double PauseTimeB = 0.0;
    //堵料时间
    private Double blockTimeA = 0.0;
    private Double blockTimeB = 0.0;
}
