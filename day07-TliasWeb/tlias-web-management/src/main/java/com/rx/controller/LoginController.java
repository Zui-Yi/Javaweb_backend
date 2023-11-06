package com.rx.controller;

import com.rx.pojo.Emp;
import com.rx.pojo.Result;
import com.rx.service.impl.EmpService;
import com.rx.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("获取的账号为:{},密码为:{}", emp.getUsername(), emp.getPassword());
        Emp e = empService.login(emp);
        //登陆成功，生成令牌，下发令牌
        if(e!=null){
            Map<String,Object> claims =new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);//jwt中包含了当前登录的员工信息
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
