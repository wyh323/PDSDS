package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.*;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        userService.update(patient);
        return Result.success();
    }

    @PatchMapping("/updatePatientAvatar")
    public Result updatePatientAvatar(@RequestParam @URL String avatarUrl){
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        userService.updatePatientAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePatientPwd")
    public Result updatePatientPwd(@RequestBody Map<String,Object> params){
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        String oldPwd = (String) params.get("oldPwd");
        String newPwd = (String) params.get("newPwd");
        String rePwd = (String) params.get("rePwd");
        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数");
        }
        String username = (String) claims.get("username");
        Patient patient = userService.findByPatientName(username);
        if(!patient.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码不正确!");
        }
        if(!rePwd.equals(newPwd)){
            return Result.error("两次输入的新密码不相同");
        }
        userService.updatePatientPwd(newPwd);
        return Result.success();
    }

    @PostMapping("/sds")
    public Result sds(@RequestBody @Validated SDS origin)  {
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        SDS sdsByPatientId = userService.findSDSByPatientId();
        if(sdsByPatientId!=null){
            return Result.error("该病人已经填写过此表");
        }
        String patient_nickname = userService.findByPatientId().getNickname();
        SDS sds = new SDS();
        sds.setPatient_nickname(patient_nickname);
        int sum = 0;
        for(int i=1;i<=20;i++){
            try {
                Field oField = origin.getClass().getDeclaredField("sds_"+i);
                oField.setAccessible(true);
                int p = (int) oField.get(origin);
                sum+=p;
                Field field = sds.getClass().getDeclaredField("sds_"+i);
                field.setAccessible(true);
                field.set(sds,p);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("程序出现内部错误");
            }
        }
        sds.setGrade(sum);
        if(sum<50){
            sds.setResult("正常");
        } else if (sum<60) {
            sds.setResult("轻微至轻度抑郁");
        } else if (sum<70) {
            sds.setResult("中至重度抑郁");
        } else {
            sds.setResult("重度抑郁");
        }
        userService.sds(sds);
        return Result.success();
    }

    @PostMapping("/ces_d")
    public Result ces_d(@RequestBody @Validated CES_D origin)  {
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        CES_D ces_dByPatientId = userService.findCES_DByPatientId();
        if(ces_dByPatientId!=null){
            return Result.error("该病人已经填写过此表");
        }
        String patient_nickname = userService.findByPatientId().getNickname();
        CES_D ces_d = new CES_D();
        ces_d.setPatient_nickname(patient_nickname);
        int sum = 0;
        for(int i=1;i<=20;i++){
            try {
                Field oField = origin.getClass().getDeclaredField("ces_d_"+i);
                oField.setAccessible(true);
                int p = (int) oField.get(origin);
                sum+=p;
                Field field = ces_d.getClass().getDeclaredField("ces_d_"+i);
                field.setAccessible(true);
                field.set(ces_d,p);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("程序出现内部错误");
            }
        }
        ces_d.setGrade(sum);
        if(sum<=15){
            ces_d.setResult("无抑郁症状");
        } else if (sum<20) {
            ces_d.setResult("有抑郁症状");
        } else {
            ces_d.setResult("重度抑郁");
        }
        userService.ces_d(ces_d);
        return Result.success();
    }

    @PostMapping("/madrs")
    public Result madrs(@RequestBody @Validated MADRS origin)  {
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        MADRS madrsByPatientId = userService.findMADRSByPatientId();
        if(madrsByPatientId!=null){
            return Result.error("该病人已经填写过此表");
        }
        String patient_nickname = userService.findByPatientId().getNickname();
        MADRS madrs = new MADRS();
        madrs.setPatient_nickname(patient_nickname);
        int sum = 0;
        for(int i=1;i<=10;i++){
            try {
                Field oField = origin.getClass().getDeclaredField("madrs_"+i);
                oField.setAccessible(true);
                int p = (int) oField.get(origin);
                sum+=p;
                Field field = madrs.getClass().getDeclaredField("madrs_"+i);
                field.setAccessible(true);
                field.set(madrs,p);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("程序出现内部错误");
            }
        }
        madrs.setGrade(sum);
        if(sum<=11){
            madrs.setResult("经过检测您处于【缓解期】，为了您和家人的幸福，建议您联系我们，进行更专业的检测。");
        } else if (sum<=21) {
            madrs.setResult("经过检测您为【轻度抑郁】，为了您和家人的幸福，建议您联系我们，进行更专业的检测。");
        } else if (sum<=29){
            madrs.setResult("经过检测您为【中度抑郁】，为了您和家人的幸福，建议您联系我们，进行更专业的检测。");
        } else if (sum<=34) {
            madrs.setResult("经过检测您为【重度抑郁】，为了您和家人的幸福，建议您联系我们，进行更专业的检测。");
        } else {
            madrs.setResult("经过检测您为【极度抑郁】，为了您和家人的幸福，建议您联系我们，进行更专业的检测。");
        }
        userService.madrs(madrs);
        return Result.success();
    }

    @GetMapping("/getSds")
    public Result<SDS_BACK> getSds(){
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        try {
            return Result.success((userService.findSDSByPatientId()).build());
        }catch (Exception e){
            return Result.error("程序出现内部错误");
        }
    }

    @GetMapping("/getCes_d")
    public Result<CES_D_BACK> getCes_d(){
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        try {
            return Result.success(userService.findCES_DByPatientId().build());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("程序出现内部错误");
        }
    }

    @GetMapping("/getMadrs")
    public Result<MADRS_BACK> getMadrs(){
        Map<String,Object> claims = ThreadLocalUtil.get();
        String security = (String) claims.get("security");
        if(!security.equals("Patient")){
            return Result.error("您没有足够的权限访问");
        }
        try {
            return Result.success(userService.findMADRSByPatientId().build());
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("程序出现内部错误");
        }
    }

    @PostMapping("/uploadPics")
    public Result uploadPics(@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2){
        if(file1.isEmpty()||file2.isEmpty()){
            return Result.error("请选择上传的图片");
        }
        String suffix1 = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));
        String suffix2 = file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf("."));
        String savePath = "D:\\uploadFolder\\";
        File fileDir = new File(savePath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        String fileName1 = savePath + "114514" + suffix1;
        String fileName2 = savePath + "19198100" + suffix2;
        try {
            file1.transferTo(new File(fileName1));
            file2.transferTo(new File(fileName2));
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("文件io正常");
        }
        return Result.success();
    }

//    @GetMapping("/provideAdvice")
//    public Result provideAdvice(){
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        String security = (String) claims.get("security");
//        if(!security.equals("Patient")){
//            return Result.error("您没有足够的权限访问");
//        }
//
//    }

}
