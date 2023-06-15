package com.cybersoft.cozastorejava21.payload.response;

public class BaseResponse {
    private int statusCode;
    private String message;
    private Object data; //Object: trả ra nhiều kiểu dữ liệu khác nhau

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
}
