package com.neux.garden.ec.runtime.exception;


import com.neux.garden.ec.runtime.api.exception.APIException;

public class MemberPointNotEnoughException extends APIException {

    public MemberPointNotEnoughException() {
        super(ErrorCode.MEMBER_POINT_NOT_ENOUGH);
    }
}
