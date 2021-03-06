package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.api.model.*;
import com.neux.garden.ec.runtime.exception.ErrorCode;
import com.neux.garden.ec.runtime.exception.LoginFailException;
import com.neux.garden.ec.runtime.exception.ProfileException;
import com.neux.garden.ec.runtime.exception.RegisterException;
import com.neux.garden.ec.runtime.jpa.model.Member;
import com.neux.garden.ec.runtime.service.bean.MailInfo;
import com.neux.garden.ec.runtime.service.data.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private DateService dateService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MailService mailService;

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

    public GenerationResponse register(RegisterRequest registerRequest) {
        GenerationResponse generationResponse = new GenerationResponse();


        saveInitMember(registerRequest);

        return generationResponse;
    }

    private Member saveInitMember(RegisterRequest registerRequest) {

        String account = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String name = registerRequest.getName();
        String birthday = registerRequest.getBirthday();

        Member member = memberService.findByID(account);
        if(member != null) throw new RegisterException(ErrorCode.MEMBER_IS_EXIST);

        member = new Member();
        member.setIsOpen("Y");
        member.setAccount(account);
        member.setPassword(StringUtils.isNotEmpty(password) ? password : "12345");
        member.setName(StringUtils.isNotEmpty(name) ? name : "");
        member.setBirthday(birthday != null ? dateService.getDate(birthday) : null);
        member.setPoint(0);
        memberService.save(member);

        return member;
    }

    public GetProfileResponse getProfile(String authorization) {
        String account = tokenService.getUsernameFromToken(authorization);

        return getProfileByUsername(account);

    }

    public GetProfileResponse getProfileByUsername(String account) {


        Member member = memberService.findByID(account);
        if(member == null) throw new ProfileException(ErrorCode.NOT_FOUND_MEMBER);
        else if("N".equalsIgnoreCase(member.getIsOpen())) throw new ProfileException(ErrorCode.MEMBER_IS_EXPIRED);

        GetProfileResponse profileResponse = new GetProfileResponse();
        Profile profile = new Profile();

        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCityId(member.getCityId());
        addressInfo.setZipcode(member.getZipcode());
        addressInfo.setAddress(member.getAddress());

        profile.setPassword(member.getPassword());
        profile.setName(member.getName());
        profile.setBirthday(dateService.toDateString(member.getBirthday(),"yyyy-MM-dd"));
        profile.setPhone(member.getPhone());
        profile.setMobile(member.getMobile());
        profile.setEmail(member.getEmail());
        profile.setAddress(addressInfo);
        profile.setPoint(member.getPoint());

        profileResponse.setBody(profile);

        return profileResponse;

    }

    public GenerationResponse updateProfile(String authorization , Profile profile) {

        String account = tokenService.getUsernameFromToken(authorization);
        Member member = memberService.findByID(account);
        if(member == null) throw new ProfileException(ErrorCode.NOT_FOUND_MEMBER);
        else if("N".equalsIgnoreCase(member.getIsOpen())) throw new ProfileException(ErrorCode.MEMBER_IS_EXPIRED);

        member.setPassword(profile.getPassword());
        member.setName(profile.getName());
        member.setBirthday(dateService.getDate(profile.getBirthday()));
        member.setEmail(profile.getEmail());
        member.setPhone(profile.getPhone());
        member.setMobile(profile.getMobile());
        member.setCityId(profile.getAddress().getCityId());
        member.setZipcode(profile.getAddress().getZipcode());
        member.setAddress(profile.getAddress().getAddress());
        member.setUpdateBy(account);

        memberService.save(member);

        return new GenerationResponse();
    }

    public GenerationResponse forgetPassword(ForgetPwdRequest forgetPwdRequest) {

        String account = forgetPwdRequest.getEmail();
        Member member = memberService.findByID(account);
        if(member == null) throw new ProfileException(ErrorCode.NOT_FOUND_MEMBER);
        else if("N".equalsIgnoreCase(member.getIsOpen())) throw new ProfileException(ErrorCode.MEMBER_IS_EXPIRED);

        MailInfo mailInfo = new MailInfo();
        mailInfo.addRecipient(account);
        mailInfo.setSubject("[?????????????????????]");
        mailInfo.setBody("??????????????????" + member.getPassword());

        mailService.sendMail(mailInfo);

        return new GenerationResponse();
    }

    public GenerationResponse addPoint(AddPointRequest pointInfo) {
        String account = pointInfo.getUsername();
        int point = pointInfo.getPoint();

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(account);

        Member member = memberService.findByID(account);
        if(member == null) member = saveInitMember(registerRequest);

        Integer originalPoint = member.getPoint();
        member.setPoint(originalPoint + point);

        memberService.save(member);

        return new GenerationResponse();
    }
}
