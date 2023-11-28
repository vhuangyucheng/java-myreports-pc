package com.solar4america.DO.response;

import lombok.Data;

@Data
public class ResultDO<T> {
    private String code;
    private String message;
    private T data;
}
