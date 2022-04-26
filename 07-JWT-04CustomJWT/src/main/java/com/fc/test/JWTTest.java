package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JWTTest {
     @Test
    public void testGetToken(){
         Map<String, Object> claim = new HashMap<>();
         claim.put("username","袁子昂");
         String token = JwtUtil.getToken(claim, "yza");
         System.out.println(token);
     }
     @Test
    public void testVerifyToken(){
         Map<String, Object> result = JwtUtil.verify("eyJhbGciOiAiSFMyNTYifQ==.eyJleHAiOjE2NTA3MDk4Mjg3NzQsImlhdCI6MTY1MDcwOTc5ODc3NCwidXNlcm5hbWUiOiLoooHlrZDmmIIifQ==.1e665e36459c2a9016d3b2641a303cb9", "yza");
         Set<Map.Entry<String, Object>> entries = result.entrySet();
         for (Map.Entry<String, Object> entry : entries) {
             System.out.println(entry.getKey()+":"+entry.getValue());
         }
     }
}
