package org.lakers.aop;

/**
 * Created on 2022/11/17 11:56
 *
 * @author lakers
 */
public class SaveOrderConvert implements LogConvert<SaveOrderReqDto> {

    @Override
    public OperateLog convert(SaveOrderReqDto dto) {
        OperateLog log = new OperateLog();
        log.setUserId(dto.getUserId());
        return log;
    }
}
