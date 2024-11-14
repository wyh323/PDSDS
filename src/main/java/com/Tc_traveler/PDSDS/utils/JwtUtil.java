package com.Tc_traveler.PDSDS.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class JwtUtil {
    private final static String jwtKey;
    private final static long jwtExpiration;
    private final static String subAdministrator = "Administrator";
    private final static String subDoctor = "Doctor";
    private final static String subPatient = "Patient";

    //获取令牌密钥和销毁时间
    static {
        try(InputStream input = JwtUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            jwtKey = properties.getProperty("jwt.key");
            //配置文件里面写long类型的数据的时候不需要后面加L
            jwtExpiration = Long.parseLong(properties.getProperty("jwt.expiration"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String genToken(Map<String,Object> claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpiration*1000))
                .setSubject("all")
                .signWith(SignatureAlgorithm.HS256, jwtKey);
        return jwtBuilder.compact();
    }

    public static Map<String,Object> parseToken(String token){
        return Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
