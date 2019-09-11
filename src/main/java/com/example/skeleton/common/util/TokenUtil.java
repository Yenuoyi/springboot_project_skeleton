package com.example.skeleton.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

/**
 * @author yebing
 */
public class TokenUtil {
    public static String createToken(SignatureAlgorithm e, String data, Date expireDate) {
        Key key = Keys.secretKeyFor(e);
        String jws = Jwts.builder().setSubject(data).signWith(key).setExpiration(expireDate).compact();
        return jws;
    }

    public static String createToken(String data, Date expireDate) {
        return createToken(SignatureAlgorithm.HS256, data, expireDate);
    }

    public static String parseToken(String data) {
        String parseResult = null;
        try {
            Claims body = Jwts.parser().parseClaimsJws(data).getBody();
            parseResult = body.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseResult;
    }
}
