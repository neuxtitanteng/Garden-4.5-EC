package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class RegisterException extends APIException {
    public RegisterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
