package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.JwtUtil;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(String username, String password){
        Administrator administrator = userService.findByAdministratorName(username);
        if(administrator == null){
            return Result.error("用户名不存在");
        }
        if(Md5Util.getMD5String(password).equals(administrator.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",administrator.getId());
            claims.put("username",administrator.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else {
            return Result.error("密码错误!");
        }
    }
}
