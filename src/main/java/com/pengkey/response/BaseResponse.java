package com.pengkey.response;

import java.io.Serializable;
import java.util.Date;

public class BaseResponse implements Serializable {
    private String responseNo;
    private String userId;
    private String code;
    private String message;
    private Date endTime;
    private Object Model;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getResponseNo() {
        return responseNo;
    }

    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getModel() {
        return Model;
    }

    public void setModel(Object model) {
        Model = model;
    }
}
