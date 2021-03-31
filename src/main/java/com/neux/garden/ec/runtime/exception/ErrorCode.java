package com.neux.garden.ec.runtime.exception;

public enum ErrorCode {
	
	NOT_FOUND_MEMBER("100", "查無使用者資料"),
	MEMBER_PASSWORD_NOT_MATCH("101", "密碼錯誤"),
	MEMBER_IS_EXIST("102", "該帳號已有人使用"),
	MEMBER_IS_EXPIRED("103", "該帳號已被停用"),
	MEMBER_POINT_NOT_ENOUGH("104", "您的累積點數不足"),

	PRODUCT_EXCHANGE_TYPE_IS_EXPIRED("200", "商品的支付方式已過期，請重新下單"),
	PRODUCT_NOT_FOUND("201", "查無此商品或此商品已下架"),
	PRODUCT_STOCK_NOT_ENOUGH("202", "該商品庫存不足"),

	UNHANDLE_ERROR("999", "系統異常")
    ;

	private String code;
	private String defaultErrorMessage;

	ErrorCode(String code, String defaultErrorMessage) {
		this.code = code;
		this.defaultErrorMessage = defaultErrorMessage;
	}

	public String toCode() {
		return code;
	}

	public String getDefaultMessage() {
		return defaultErrorMessage;
	}
}
