package com.xiaoci.im.exception;

import com.xiaoci.im.constant.ExceptionMessage;
import com.xiaoci.im.domain.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult runtimeExceptionHandler(RuntimeException e) {
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 异常
     */
    @ExceptionHandler({Exception.class})
    public AjaxResult exceptionHandler(Exception e) {
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    public AjaxResult nullPointerExceptionHandler(NullPointerException e) {
        return AjaxResult.error(ExceptionMessage.NULL_POINTER_EXCEPTION);
    }
}
