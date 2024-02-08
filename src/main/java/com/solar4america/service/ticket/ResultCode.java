package com.solar4america.service.ticket;

import com.solar4america.exception.ErrorCodeBase;

public class ResultCode {
    public static final String CODE_NUMBER = String.valueOf(ErrorCodeBase.KPI + 1L);
    public static final String MSG_NUMBER = "数量不够";

    public static final String CODE_RECORD = String.valueOf(ErrorCodeBase.KPI + 2L);
    public static final String MSG_RECORD = "没有这个辅料出入库纪录";
}
