package com.solar4america.stringerClient;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Shift {
    @NonNull
    private String shiftName;

    private int OKStringA = 0;
    private int OKStringB = 0;
    private int NGStringA = 0;
    private int NGStringB = 0;
    private int NGCellA = 0;
    private int NGCellB = 0;
    //故障时间
    private int autoFaultTimeA = 0;
    private int autoFaultTimeB = 0;
    //缺料时间
    private int autoMissingMaterialTimeA = 0;
    private int autoMissingMaterialTimeB = 0;
    //手动时间
    private int ManualRunTimeA = 0;
    private int ManualRunTimeB = 0;
    //自动运行时间
    private int autoRunTimeA = 0;
    private int autoRunTimeB = 0;
    //换料时间
    private int autoSuspendTimeA = 0;
    private int autoSuspendTimeB = 0;
    //堵料时间
    private int blockTimeA = 0;
    private int blockTimeB = 0;
}
