package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.JwtUtil;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import com.Tc_traveler.PDSDS.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{1,15}$") String username,@Pattern(regexp = "^\\S{8,32}$") String password){
        Doctor doctor = userService.findByDoctorName(username);
        if(doctor == null){
            userService.registerDoctor(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已经被使用!");
        }
    }

    @PostMapping("/login")
    public Result<String> login(String username,String password){
        Doctor doctor = userService.findByDoctorName(username);
        if(doctor == null){
            return Result.error("用户名不存在");
        }
        if(Md5Util.getMD5String(password).equals(doctor.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",doctor.getId());
            claims.put("username",doctor.getUsername());
            claims.put("security",doctor.getClass().getSimpleName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else {
            return Result.error("密码错误!");
        }
    }

    @GetMapping("/myPatientsInfo")
    public Result<List<Patient>> myPatientsInfo(/*@RequestHeader(name = "Authorization")String token*/){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        int id = (int) map.get("id");
        if(!security.equals("Doctor")){
            return Result.error("您没有足够的权限访问");
        }
        List<Patient> patients = userService.myPatientsInfo(id);
        return Result.success(patients);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Doctor doctor){
        userService.update(doctor);
        return Result.success();
    }
}
