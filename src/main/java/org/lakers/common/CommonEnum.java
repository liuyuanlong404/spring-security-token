package org.lakers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 2022/11/5 10:35
 *
 * @author lakers
 */
@AllArgsConstructor
@Getter
public enum CommonEnum implements BaseErrorInfo {


    /**
     * 返回枚举
     */
    SUCCESS(200, "请求成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    /** 错误码 */
    private final Integer resultCode;

    /** 错误描述 */
    private final String resultMsg;
}
