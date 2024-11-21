package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.JwtUtil;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import com.Tc_traveler.PDSDS.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
            claims.put("security",administrator.getClass().getSimpleName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else {
            return Result.error("密码错误!");
        }
    }

    @GetMapping("/allDoctorInfo")
    public Result<List<Doctor>> allDoctorInfo(/*@RequestHeader(name = "Authorization")String token*/){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        List<Doctor> results = userService.findAllDoctor();
        return Result.success(results);
    }
}
