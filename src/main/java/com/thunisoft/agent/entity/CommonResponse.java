/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.entity
 * @className com.thunisoft.agent.entity.CommonResponse
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.entity;

import java.io.Serializable;

/**
 * CommonResponse
 * @description
 * @author tlz
 * @date 2019-05-13 10:51
 * @version 1.1.0
 */
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1893568482234044793L;

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
