package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.api.model.LoginBody;
import com.neux.garden.ec.runtime.api.model.LoginRequest;
import com.neux.garden.ec.runtime.api.model.LoginResponse;
import com.neux.garden.ec.runtime.api.model.ResponseHeader;
import com.neux.garden.ec.runtime.exception.ErrorCode;
import com.neux.garden.ec.runtime.exception.LoginFailException;
import com.neux.garden.ec.runtime.jpa.model.Member;
import com.neux.garden.ec.runtime.service.data.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenService tokenService;

    public LoginResponse login(LoginRequest loginInfo) {
        LoginResponse loginResponse = new LoginResponse();
        LoginBody loginBody = new LoginBody();

        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        Member member = memberService.findByID(username);
        if(member == null) throw new LoginFailException(ErrorCode.NOT_FOUND_MEMBER);
        if(!member.getPassword().equalsIgnoreCase(password)) throw new LoginFailException(ErrorCode.MEMBER_PASSWORD_NOT_MATCH);

        Map<String, Object> claims = new HashMap<>();
        claims.put("Username", username);

        String jwtToken = tokenService.generateToken(claims);
        loginBody.setSuccess(true);
        loginBody.setToken(jwtToken);

        loginResponse.setBody(loginBody);

        return loginResponse;
    }
}
