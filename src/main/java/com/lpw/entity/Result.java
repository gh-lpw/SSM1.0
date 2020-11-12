package com.lpw.entity;

/**
 * @author lipw4
 */
public class Result {

    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private Object data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
