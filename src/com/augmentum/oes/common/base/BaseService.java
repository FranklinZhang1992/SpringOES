package com.augmentum.oes.common.base;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import com.augmentum.oes.exception.ParameterException;

public abstract class BaseService {

    protected Validator validator = null;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    protected Boolean validateObject(Object o) throws ParameterException {

        List<ConstraintViolation> violations = validator.validate(o);
        if (violations != null && !violations.isEmpty()) {
            ParameterException parameterException = new ParameterException();
            for (ConstraintViolation violation : violations) {
                String ovalField = violation.getContext().toString();
                Integer index = ovalField.lastIndexOf(".");
                String fieldName = ovalField.substring(index + 1, ovalField.length()) + "Error";
                String message = violation.getMessage();
                parameterException.addErrorParameter(fieldName, message);
            }
            if (parameterException.hasErrorParameter()) {
                throw parameterException;
            }
        }
        return Boolean.TRUE;
    }


}
