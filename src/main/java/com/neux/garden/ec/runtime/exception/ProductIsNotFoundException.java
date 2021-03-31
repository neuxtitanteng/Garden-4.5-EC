package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class ProductIsNotFoundException extends APIException {
    private String productId = null;

    public ProductIsNotFoundException(String productId) {
        super(ErrorCode.PRODUCT_NOT_FOUND);
        this.productId = productId;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage() + ":商品編號[" + productId + "]";
    }
}
