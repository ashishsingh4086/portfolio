package com.ashish.portfolio.common.core.endpoint;

import org.springframework.http.HttpStatus;

public class ResponseResult<T> {
    private HttpStatus status;
    private int code;
    private T responseBody;

    public ResponseResult(HttpStatus status, int code, T responseBody) {
        this.status = status;
        this.code = code;
        this.responseBody = responseBody;

    }

    public ResponseResult(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }

    public static <T> EndPointResponse<?> ok(T body) {
        return new EndPointResponse<>(body, HttpStatus.OK);
    }

    public static <T> EndPointResponse<?> ok() {
        return new EndPointResponse<>(HttpStatus.OK);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }
}
