package com.company.evaluationwebapi.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public List<Map<String, Object>> buildListError (ServiceException ex) {
        Map<String, Object> mapError = new HashMap<>();
        mapError.put(ex.getMessage(), ex);
        List<Map<String, Object>> listError = new ArrayList<>();
        listError.add(mapError);
        return listError;
    }

}
