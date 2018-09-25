package com.jack.common;

public class Result {
    private String code;

    private String msg;

    private Object data;

    private boolean success;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode("200");
        result.setSuccess(true);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode("200");
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
