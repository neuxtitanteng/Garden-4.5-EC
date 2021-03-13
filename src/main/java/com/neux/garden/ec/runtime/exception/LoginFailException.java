package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class LoginFailException extends APIException {
    public LoginFailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
