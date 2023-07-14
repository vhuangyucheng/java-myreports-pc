package com.solar4america.stringerClient;

import lombok.Data;

@Data
public class Shift {
    private int OKStringA = 0;
    private int OKStringB = 0;
    private int NGStringA = 0;
    private int NGStringB = 0;
    private int NGCellA = 0;
    private int NGCellB = 0;
    //故障时间
    private int ErrorTimeA = 0;
    private int ErrorTimeB = 0;
    //缺料时间
    private int lackTimeA = 0;
    private int lackTimeB = 0;
    //手动时间
    private int ManualTimeA = 0;
    private int ManualTimeB = 0;
    //自动运行时间
    private int RunTimeA = 0;
    private int RunTimeB = 0;
    //自动暂停时间
    private int pauseTimeA = 0;
    private int pauseTimeB = 0;
    //堵料时间
    private int stopTime = 0;
}
