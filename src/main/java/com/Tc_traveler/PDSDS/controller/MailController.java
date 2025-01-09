package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("/getCode")
    public Result getCode(@RequestBody Map<String,Object> params){
        String email = (String) params.get("email");
        String username = (String) params.get("username");
        Doctor doctor = mailService.findDoctorByUsernameAndEmail(username,email);
        if(doctor == null){
            return Result.error("您没有绑定邮箱或您还为注册/通过审核");
        }
        mailService.getCode(email);
        return Result.success();
    }
}
