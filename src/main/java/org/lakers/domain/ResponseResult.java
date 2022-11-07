package org.lakers.domain;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.lakers.common.BaseErrorInfo;
import org.lakers.common.CommonEnum;

/**
 * Created on 2022/11/3 13:16
 *
 * @author lakers
 */
@Data
public class ResponseResult<T> {

    @ApiModelProperty(value = "响应状态码")
    private Integer code;

    @ApiModelProperty(value = "响应信息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    private ResponseResult(){

    }

    public ResponseResult(BaseErrorInfo errorInfo){
        this.code = errorInfo.getResultCode();
        this.msg = errorInfo.getResultMsg();
    }

    public ResponseResult(BaseErrorInfo errorInfo, T data){
        this.code = errorInfo.getResultCode();
        this.msg = errorInfo.getResultMsg();
        this.data = data;
    }

    public ResponseResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <R> ResponseResult<R> success() {
        return new ResponseResult<>(CommonEnum.SUCCESS);
    }

    public static <R> ResponseResult<R> success(String msg){
        return new ResponseResult<>(CommonEnum.SUCCESS.getResultCode(), msg);
    }

    public static <R> ResponseResult<R> success(R data) {
        return new ResponseResult<>(CommonEnum.SUCCESS, data);
    }

    public static <R> ResponseResult<R> error() {
        return new ResponseResult<>(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    public static <R> ResponseResult<R> error(String msg){
        return new ResponseResult<>(CommonEnum.INTERNAL_SERVER_ERROR.getResultCode(), msg);
    }

    public static <R> ResponseResult<R> error(Integer code, String msg){
        return new ResponseResult<>(code, msg);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
