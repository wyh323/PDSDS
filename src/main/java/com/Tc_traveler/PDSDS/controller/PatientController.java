package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.SDS;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.JwtUtil;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import com.Tc_traveler.PDSDS.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{1,15}$") String username, @Pattern(regexp = "^\\S{8,32}$") String password){
        Patient patient = userService.findByPatientName(username);
        if(patient == null){
            userService.registerPatient(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已经被使用!");
        }
    }

    @PostMapping("/login")
    public Result<String> login(String username,String password){
        Patient patient = userService.findByPatientName(username);
        if(patient == null){
            return Result.error("用户名不存在");
        }
        if(Md5Util.getMD5String(password).equals(patient.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",patient.getId());
            claims.put("username",patient.getUsername());
            claims.put("security",patient.getClass().getSimpleName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else {
            return Result.error("密码错误!");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Patient patient){
        userService.update(patient);
        return Result.success();
    }

//    @PatchMapping("/updatePatientAvatar")
//    public Result updatePatientAvatar(@RequestParam @URL String avatarUrl){
//        userService.updatePatientAvatar(avatarUrl);
//        return Result.success();
//    }

//    @PatchMapping("/updatePatientPwd")
//    public Result updatePatientPwd(@RequestBody Map<String,Object> params){
//        String oldPwd = (String) params.get("oldPwd");
//        String newPwd = (String) params.get("newPwd");
//        String rePwd = (String) params.get("rePwd");
//        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
//            return Result.error("缺少必要的参数");
//        }
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        String username = (String) claims.get("username");
//        Patient patient = userService.findByPatientName(username);
//        if(!patient.getPassword().equals(Md5Util.getMD5String(oldPwd))){
//            return Result.error("原密码不正确!");
//        }
//        if(!rePwd.equals(newPwd)){
//            return Result.error("两次输入的新密码不相同");
//        }
//        userService.updatePatientPwd(newPwd);
//        return Result.success();
//    }

//    @PostMapping("/sds")
//    public Result sds(@RequestBody @Validated SDS origin)  {
//        SDS sds = new SDS();
//        int sum = 0;
//        for(int i=1;i<=20;i++){
//            try {
//                Field oField = origin.getClass().getField("sds_"+i);
//                oField.setAccessible(true);
//                int p = (int) oField.get(origin);
//                sum+=p;
//                Field field = sds.getClass().getField("sds_"+i);
//                field.setAccessible(true);
//                field.set(sds,p);
//            } catch (Exception e) {
//                return Result.error("程序出现内部错误");
//            }
//        }
//        sds.setGrade(sum);
//        if(sum<50){
//            sds.setResult("正常");
//        } else if (sum<60) {
//            sds.setResult("轻微至轻度抑郁");
//        } else if (sum<70) {
//            sds.setResult("中至重度抑郁");
//        } else {
//            sds.setResult("重度抑郁");
//        }
//        userService.sds(sds);
//        return Result.success();
//    }
}
