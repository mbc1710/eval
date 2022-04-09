package com.company.evaluationwebapi.utils;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class Response<T> extends AbstractResponse<T> {

    private static final long serialVersionUID = 1L;
    private String message;

    public Response() {
    }

    public Response(HttpStatus status, T responseBody, String message) {
        super(status.value(), responseBody);
        this.message = message;
    }

    public Response(HttpStatus status, List<Map<String, Object>> errorResponseBody, String message) {
        super.setStatus(status.value());
        super.setErrorResponseBody(errorResponseBody);
        this.message = message;
    }

    public Response(T responseBody) {
        this(HttpStatus.OK, responseBody, null);
    }

    public Response(T responseBody, String message) {
        this(responseBody);
        this.message = message;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

}
