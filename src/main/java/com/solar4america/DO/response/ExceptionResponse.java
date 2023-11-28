package com.solar4america.DO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    /** 是否成功*/
    private String code;
    /** 消息*/
    private String message;
}