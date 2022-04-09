package com.company.evaluationwebapi.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AbstractResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer status;
    private T responseBody;
    private List<Map<String, Object>> errorResponseBody;

    public AbstractResponse() {
    }

    public AbstractResponse(Integer status, T responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public T getResponseBody () {
        return responseBody;
    }

    public void setResponseBody (T responseBody) {
        this.responseBody = responseBody;
    }

    public List<Map<String, Object>> getErrorResponseBody () {
        return errorResponseBody;
    }

    public void setErrorResponseBody (List<Map<String, Object>> errorResponseBody) {
        this.errorResponseBody = errorResponseBody;
    }

}
