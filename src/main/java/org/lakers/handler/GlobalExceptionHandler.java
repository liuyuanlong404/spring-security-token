package org.lakers.handler;

import lombok.extern.slf4j.Slf4j;
import org.lakers.common.CommonEnum;
import org.lakers.domain.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public <T> ResponseResult<T> bizException(BizException e) {
        log.error(e.getMessage(), e);
        return ResponseResult.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public <T> ResponseResult<T> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return ResponseResult.error(202, "请求方式有误！");
    }

    @ExceptionHandler(value = Exception.class)
    public <T> ResponseResult<T> exception(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseResult.error(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void accessDeniedException(AccessDeniedException e) {
        throw e;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public <T> ResponseResult<T> methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            return new ResponseResult<>(202, fieldError.getDefaultMessage());
        }

        return new ResponseResult<>(CommonEnum.BODY_NOT_MATCH);
    }

}
