package com.example.mlTest.springresource.jdbc;

import java.io.Serializable;

/**
 * @author miaoliang
 * @since 8/1/21 8:21 PM
 */
public class ResultMsg<T> implements Serializable {

    private static final long serialVersionUID = -5945314690639170111L;

    private int status;

    private String msg;

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
