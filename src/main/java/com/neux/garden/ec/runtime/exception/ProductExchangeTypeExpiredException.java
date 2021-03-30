package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class ProductExchangeTypeExpiredException extends APIException {
    public ProductExchangeTypeExpiredException(ErrorCode errorCode) {
        super(errorCode);
    }
}
