package com.neux.garden.ec.runtime.exception;

public enum ErrorCode {
	
	NOT_FOUND_MEMBER("100", "查無使用者資料"),
    MEMBER_PASSWORD_NOT_MATCH("101", "密碼錯誤"),
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
