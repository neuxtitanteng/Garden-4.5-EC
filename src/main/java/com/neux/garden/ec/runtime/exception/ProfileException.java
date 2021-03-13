package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class ProfileException extends APIException {
    public ProfileException(ErrorCode errorCode) {
        super(errorCode);
    }
}
