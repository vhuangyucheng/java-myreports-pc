package com.solar4america.exception;

public class GlobalCode {
    public static final String CODE_CONTROLLER = String.valueOf(ErrorCodeBase.Global + 1L);
    public static final String MSG_CONTROLLER = "控制层入参错误";

    public static final String CODE_SERVICE = String.valueOf(ErrorCodeBase.Global + 2L);
    public static final String MSG_SERVICE = "服务入参错误";

    public static final String CODE_404 = String.valueOf(ErrorCodeBase.Global + 3L);
    public static final String MSG_404 = "没有这个api接口";

    public static final String CODE_UNKNOWN = String.valueOf(ErrorCodeBase.Global + 4L);
    public static final String MSG_UNKNOWN = "服务器未知错误";
}
