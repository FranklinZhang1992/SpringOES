package com.augmentum.oes.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception {

    private static final long serialVersionUID = 909017899154954423L;

    private Map<String, String> errorParameters = new HashMap<String, String>();

    public Map<String, String> getErrorParameters() {
        return errorParameters;
    }

    public void setErrorParameters(Map<String, String> errorParameters) {
        this.errorParameters = errorParameters;
    }

    public void addErrorParameter(String fieldName, String errorMessage) {
        if (errorParameters == null) {
            errorParameters = new HashMap<String, String>();
        }
        errorParameters.put(fieldName, errorMessage);
    }

    public boolean hasErrorParameter() {
        if (errorParameters == null || errorParameters.isEmpty()) {
            return false;
        }
        return true;

    }

}
