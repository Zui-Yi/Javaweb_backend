package com.rx;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenJwt(){

        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "rx666")//签名算法
                .setClaims(claims)//自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为一小时
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("rx666")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTY5OTI2NzQ2Mn0.IRbhktzX8Xw04Kfbg3j_B4u0wW_-wy9njPz_GAh-eo4")
                .getBody();
        System.out.println(claims);
    }

}
