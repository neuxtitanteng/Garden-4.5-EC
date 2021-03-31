package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class ProductStockIsNotEnoughException extends APIException {
    private String productName = null;

    public ProductStockIsNotEnoughException(String productName) {
        super(ErrorCode.PRODUCT_STOCK_NOT_ENOUGH);
        this.productName = productName;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage() + ":商品[" + productName + "]";
    }
}
