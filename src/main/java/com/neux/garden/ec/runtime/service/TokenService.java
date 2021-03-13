package com.neux.garden.ec.runtime.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/3/16
 * Time: 下午 12:28
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TokenService {

    private Logger logger = LoggerFactory.getLogger(TokenService.class);

    @Value("${jwt.secret}")
    private String secret = "1234567890123456789012345678901234567890123456789012345678901234";

    @Value("${jwt.expirationMin}")
    private String expirationMin;

    @Autowired
    private DateService dateService = new DateService();

    private Claims parseToken(String token) {

        try{

            if (StringUtils.isNotEmpty(token) && token.startsWith("Bearer ")){
                token = token.substring(7);
            }

            String base64Key = DatatypeConverter.printBase64Binary(secret.getBytes());
            byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);

            return Jwts.parser()
                    .setSigningKey(secretBytes)
                    .parseClaimsJws(token)
                    .getBody();
        }catch(Exception e) {
            logger.error("jwt token parse is error[" + token + "] , ErrorMsg:["+e.getMessage()+"]");
        }

        return null;
    }

    public String getUsernameFromToken(String token) {
        return getValueFromToken(token,"Username");
    }

    public String getValueFromToken(String token,String name) {
        Claims claims = parseToken(token);
        return claims != null && claims.containsKey(name) ? String.valueOf(claims.get(name)) : null;
    }

    public Claims getClaims(String token) {
        return parseToken(token);
    }

    public String generateToken(Map<String, Object> claims) {

        return generateToken(claims,true);
    }

    public String generateToken(Map<String, Object> claims , boolean isExpirationToken) {

        String base64Key = DatatypeConverter.printBase64Binary(secret.getBytes());
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretBytes);

        if(isExpirationToken) jwtBuilder.setExpiration(generateExpirationDate());

        return jwtBuilder.compact();

    }

    private Date generateExpirationDate() {
        return dateService.addDate(new Date(), Calendar.MINUTE,Integer.parseInt(expirationMin));
    }
}
