package com.solar4america.exception;

import com.solar4america.DO.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

@RestController
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Object noHandlerFoundException(HttpServletRequest req, Exception e) throws Exception {
        log.error("---404 Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return new ExceptionResponse(GlobalCode.CODE_404, GlobalCode.MSG_404);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object bindException(HttpServletRequest req, Exception e) throws Exception {
        log.error("---controller---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return new ExceptionResponse(GlobalCode.CODE_CONTROLLER, GlobalCode.MSG_CONTROLLER);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Object methodArgumentNotValidException(HttpServletRequest req, Exception e) throws Exception {
        log.error("---service---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return new ExceptionResponse(GlobalCode.CODE_SERVICE, GlobalCode.MSG_SERVICE);
    }

    @ExceptionHandler(BaseServiceException.class)
    public Object BaseServiceException(HttpServletRequest req, BaseServiceException e) {
        log.error("---service Exception Handler---Host {} invokes url {} CODE:{}  MESSAGE: {}", req.getRemoteHost()
                , req.getRequestURL()
                , e.getCode()
                , e.getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(e.getCode());
        exceptionResponse.setMessage(e.getMessage());
        return exceptionResponse;
    }


    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest req, Exception e)  {
        log.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return new ExceptionResponse(GlobalCode.CODE_UNKNOWN, GlobalCode.MSG_UNKNOWN);
    }

}
