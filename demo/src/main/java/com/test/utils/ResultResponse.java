package com.test.utils;

public class ResultResponse {

    private int status;

    private String message;

    private boolean success;

    Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultResponse success(String message, Object data) {
        ResultResponse response = new ResultResponse();
        response.setStatus(FinalStatus.successCode);
        response.setMessage(message);
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static ResultResponse success(Object data) {
        ResultResponse response = new ResultResponse();
        response.setStatus(FinalStatus.successCode);
        response.setMessage("请求成功");
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static ResultResponse success() {
        ResultResponse response = new ResultResponse();
        response.setStatus(FinalStatus.successCode);
        response.setMessage("请求成功");
        response.setData(null);
        response.setSuccess(true);
        return response;
    }

    public static ResultResponse error(String message) {
        ResultResponse response = new ResultResponse();
        response.setStatus(FinalStatus.errorCode);
        response.setMessage(message);
        response.setData(null);
        response.setSuccess(false);
        return response;
    }
}
