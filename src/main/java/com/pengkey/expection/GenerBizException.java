package com.pengkey.expection;

public class GenerBizException extends Exception{
    private String code;
    private String msg;
    private boolean language;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public GenerBizException() {
        language=false;
    }

    public GenerBizException(String msg) {
        this.msg = msg;
    }

    public GenerBizException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
