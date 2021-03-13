
/*
* <p> Source File Name: APIException.java </p>
*/

package com.neux.garden.ec.runtime.api.exception;

import com.neux.garden.ec.runtime.exception.ErrorCode;

public class APIException extends RuntimeException{
    private String errorCode = null;
    private String errorMessage = null;

    public APIException(ErrorCode errorCode) {
        this.errorCode = errorCode.toCode();
        this.errorMessage = errorCode.getDefaultMessage();
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
    