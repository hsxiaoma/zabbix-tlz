/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.utils
 * @className com.thunisoft.agent.utils.ResponseResultUtil
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.utils;

import com.thunisoft.agent.entity.CommonResponse;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * ResponseResultUtil
 * @description
 * @author tlz
 * @date 2019-05-13 10:55
 * @version 1.1.0
 */
public class ResponseResultUtil  implements Serializable {



    public static <T> CommonResponse<T>  success(T data){
        CommonResponse<T> result = new CommonResponse<T>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode(HttpStatus.OK.value());
        return result;
    }

    public static <T> CommonResponse<T>  success(T data,String message){
        CommonResponse<T> result = new CommonResponse<T>();
        result.setData(data);
        result.setSuccess(true);
        result.setMessage(message);
        result.setCode(HttpStatus.OK.value());
        return result;
    }


    public static <T> CommonResponse<T>  error(String message){
        CommonResponse<T> result = new CommonResponse<T>();
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(HttpStatus.EXPECTATION_FAILED.value());
        return result;
    }

}
