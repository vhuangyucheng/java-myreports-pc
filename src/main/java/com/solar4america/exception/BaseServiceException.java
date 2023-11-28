package com.solar4america.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseServiceException extends RuntimeException {
    private String code;
    private String message;
}
