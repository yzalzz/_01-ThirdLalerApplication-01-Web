package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtUtilTest {
    @Test
    public void testCreate() {
        Map<String, Object> claim = new HashMap<>();

        claim.put("id", "1");
        claim.put("username", "易烊千玺");

        String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 60);

        System.out.println(token);
    }

    @Test
    public void testParse() {
        Map<String, Object> map = JwtUtil.getClaim("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbSI6eyJpZCI6IjEiLCJ1c2VybmFtZSI6IuaYk-eDiuWNg-eOuiJ9LCJleHAiOjE2NDkxMjE2Nzl9.eAZA3_2PYwuwYtyPLuPNDrg_pIUT4SyoA2pQoDPT-Ds");
        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
