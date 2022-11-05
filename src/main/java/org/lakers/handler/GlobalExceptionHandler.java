package org.lakers.handler;

import lombok.extern.slf4j.Slf4j;
import org.lakers.domain.ResponseResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created on 2022/11/5 11:00
 *
 * @author lakers
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public <T> ResponseResult<T> bizException(BizException e){
        log.error(e.getMessage(), e);
        return ResponseResult.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public <T> ResponseResult<T> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.error(e.getMessage(), e);
        return ResponseResult.error(202, "请求方式有误！");
    }

    @ExceptionHandler(value = Exception.class)
    public <T> ResponseResult<T> exception(Exception e){
        log.error(e.getMessage(), e);
        return ResponseResult.error(e.getMessage());
    }

}
