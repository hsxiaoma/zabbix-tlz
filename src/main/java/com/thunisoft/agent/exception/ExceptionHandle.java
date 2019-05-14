/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.exception
 * @className com.thunisoft.agent.exception.ExceptionHandle
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.exception;

import com.thunisoft.agent.entity.CommonResponse;
import com.thunisoft.agent.utils.ResponseResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ExceptionHandle
 * @description
 * @author tlz
 * @date 2019-05-13 10:47
 * @version 1.1.0
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResponse  handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return ResponseResultUtil.error("请求出错。");
    }
}
