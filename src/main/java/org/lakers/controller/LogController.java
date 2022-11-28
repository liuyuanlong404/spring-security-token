package org.lakers.controller;

import io.swagger.annotations.ApiOperation;
import org.lakers.aop.RecordOperate;
import org.lakers.aop.SaveOrderConvert;
import org.lakers.aop.SaveOrderReqDto;
import org.lakers.domain.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2022/11/17 11:32
 *
 * @author lakers
 */
@RestController
public class LogController {

    @ApiOperation(value = "保存订单")
    @GetMapping(value = "/saveOrder")
    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
    public ResponseResult<Void> hello(SaveOrderReqDto dto) {
        return ResponseResult.success();
    }
}
