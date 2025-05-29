package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.*;
import com.Tc_traveler.PDSDS.service.AdviceService;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.JwtUtil;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import com.Tc_traveler.PDSDS.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdviceService adviceService;

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

    @GetMapping("/allPatientInfo")
    public Result<List<Patient>> allPatientInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        List<Patient> result = userService.findAllPatient();
        return Result.success(result);
    }

    @DeleteMapping("/deleteDoctor")
    public Result deleteDoctor(@Pattern(regexp = "^\\S{1,15}$") String username){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        Doctor doctor = userService.findByDoctorName(username);
        if(doctor==null){
            return Result.error("没有该名医生");
        }
        userService.deleteDoctor(username);
        return Result.success();
    }

    //所有备用医生 管理员进行审核
    @GetMapping("/getAllDoctor_1")
    public Result<List<Doctor>> getAllDoctor_1(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        return Result.success(userService.getAllDoctor_1());
    }

    @PostMapping("/check")
    public Result check(String username){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        Doctor doctor = userService.findByDoctor_1Name(username);
        if(doctor==null){
            return Result.error("待审核的医生中没有此人");
        }
        userService.deleteDoctor_1(username);
        userService.checkDoctor(doctor);
        return Result.success();
    }

    @PutMapping("/addAdvice")
    public Result addAdvice(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("photo") MultipartFile photo){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        try {
            adviceService.addAdvice(title,content,photo);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    @GetMapping("/getAllAdvice")
    public Result<List<AdviceBack>> getAllAdvice(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        return Result.success(adviceService.getAllAdvice());
    }

    @GetMapping("/getAdvice")
    public Result<Advice> getAdvice(@RequestParam("id")int id){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        Advice advice = adviceService.getAdvice(id);
        if(advice==null){
            return Result.error("您要找的文章已消失");
        }
        return Result.success(advice);
    }

    @DeleteMapping("/deleteAdvice")
    public Result deleteAdvice(@RequestParam("id")int id){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        Advice advice = adviceService.getAdvice(id);
        if(advice==null){
            return Result.error("您要删除的文章不存在");
        }
        adviceService.deleteAdvice(id,advice.getPhoto());
        return Result.success();
    }

    @PatchMapping("/updateAdvice")
    public Result updateAdvice(@RequestParam("id") int id,@RequestParam("title") String title, @RequestParam("content") String content, @Nullable @RequestParam("photo") MultipartFile photo){
        Map<String,Object> map = ThreadLocalUtil.get();
        String security = (String) map.get("security");
        if(!security.equals("Administrator")){
            return Result.error("您没有足够的权限访问");
        }
        Advice advice = adviceService.getAdvice(id);
        if(advice==null){
            return Result.error("您要修改的文章不存在");
        }
        try {
            adviceService.updateAdvice(id,title,content,photo,advice);
        }catch (IOException e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

}
