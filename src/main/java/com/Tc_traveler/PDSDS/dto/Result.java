package com.Tc_traveler.PDSDS.dto;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;//业务状态码 0-成功 1-失败
    private String message;//提示信息
    private T data;//响应数据

    /**
     * 无参构造
     */
    public Result() {
    }

    /**
     * 有参构造
     */
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    //快速返回操作出错响应结果，不包含任何结果数据
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}