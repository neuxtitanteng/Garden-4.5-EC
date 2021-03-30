package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class ProductIsNotFoundException extends APIException {
    private String productName = null;

    public ProductIsNotFoundException(String productName) {
        super(ErrorCode.PRODUCT_EXCHANGE_TYPE_IS_EXPIRED);
        this.productName = productName;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage() + ":" + productName;
    }
}
