package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return Result.success("return JWT.");
        }else {
            return Result.error("密码错误!");
        }
    }
}
