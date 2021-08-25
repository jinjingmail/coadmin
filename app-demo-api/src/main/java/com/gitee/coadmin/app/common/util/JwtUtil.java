package com.gitee.coadmin.app.common.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by jinjin on 2020-10-13.
 */
@Component
public class JwtUtil {
    private static String jwtKey;
    private static Integer expiredTimeIn;
    private static final Integer DEFAULT_LEVEL = 6;

    // @Value("${app-demo.security.jwt-key}")
    @Value("${jwt.online-key}")
    public void setJwtKey(String jwtKey) {
        JwtUtil.jwtKey = jwtKey;
    }

    // @Value("${app-demo.security.token-expired-in}")
    @Value("${jwt.token-validity-in-seconds}")
    public void setExpiredTimeIn(Integer expiredTimeIn) {
        JwtUtil.expiredTimeIn = expiredTimeIn;
    }

    public static Optional<Map<String, Claim>> getClaims(String token) {
        DecodedJWT decodedJWT;
        Algorithm algorithm = Algorithm.HMAC256(JwtUtil.jwtKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(decodedJWT.getClaims());
    }

    public static Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtUtil.jwtKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    public static String getExpireTime(String token){
        return DateUtil.formatDateTime(JWT.decode(token).getExpiresAt());
    }

    public static String makeToken(Long uid, Integer level) {
        return JwtUtil.getToken(uid, level);
    }

    public static String makeToken(Long uid) {
        return JwtUtil.getToken(uid, JwtUtil.DEFAULT_LEVEL);
    }

    private static String getToken(Long uid, Integer level) {
        Algorithm algorithm = Algorithm.HMAC256(JwtUtil.jwtKey);
        Map<String,Date> map = JwtUtil.calculateExpiredIssues();

        return JWT.create()
                .withClaim("uid", uid)
                .withClaim("level", level)
                .withExpiresAt(map.get("expiredTime"))
                .withIssuedAt(map.get("now"))
                .sign(algorithm);
    }

    private static Map<String, Date> calculateExpiredIssues() {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, JwtUtil.expiredTimeIn);
        map.put("now", now);
        map.put("expiredTime", calendar.getTime());
        return map;
    }

}
