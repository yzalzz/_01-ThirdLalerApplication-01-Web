package com.fc.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.*;

public class JwtTest {

    @Test
    public void encode1(){
        Map<String , Object> header = new HashMap<>();
        //头部里面有 alg ,typ
        header.put("alg","HS256");
        header.put("typ","JWT");

        //日历对象
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,30);
        //token
        String token = JWT.create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","易烊千玺")
                .withClaim("info","管理员")
                .withClaim("createTime",new Date())
                .withClaim("exp",calendar.getTime())
                //发布者
                .withIssuer("袁子昂")
                //发布时间
                .withIssuedAt(new Date())
                //过期时间
                .withExpiresAt(calendar.getTime())
                //签名 里面放盐值用于加密解密
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }











    //编码
    @Test
    public void encode(){
        Map<String , Object> header = new HashMap<>();
        //头部里面有 alg ,typ
        header.put("alg","HS256");
        header.put("typ","JWT");

        //载荷
        Map<String, Object> payload = new HashMap<>();

        //日历对象
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,30);

        payload.put("id",1);
        payload.put("username","易烊千玺");
        payload.put("info","管理员");
        payload.put("createTime",new Date());
        //设置过期时间
        payload.put("exp",calendar.getTime());


        //token
        String token = JWT.create()
                .withHeader(header)
                .withPayload(payload)
                //签名 里面放盐值用于加密解密
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }

    //解码
    @Test
    public void decode(){
        //获取验证器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("123456")).build();

        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVUaW1lIjoxNjQ5MDgyNzYyLCJpc3MiOiLoooHlrZDmmIIiLCJpZCI6MSwiZXhwIjoxNjQ5MDgyNzkyLCJpYXQiOjE2NDkwODI3NjIsInVzZXJuYW1lIjoi5piT54OK5Y2D5466IiwiaW5mbyI6IueuoeeQhuWRmCJ9.MrhL0q-93A5oAupuWUd0q4d1EKVt3sls8qCAM1Tms5E");
        //没啥用
        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getExpiresAt());

        //
        System.out.println(decodedJWT.getClaim("username"));
        System.out.println(decodedJWT.getClaim("createTime"));
        System.out.println(decodedJWT.getClaim("info"));
        System.out.println(decodedJWT.getClaim("id"));
        Map<String, Claim> claims = decodedJWT.getClaims();
        //遍历map
        Set<Map.Entry<String, Claim>> entries = claims.entrySet();
        for (Map.Entry<String, Claim> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
