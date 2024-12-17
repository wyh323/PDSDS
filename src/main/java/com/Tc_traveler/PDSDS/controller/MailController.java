package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("/getCode")
    public Result getCode(String email){
        Doctor doctor = mailService.findByDoctorEmail(email);
        if(doctor == null){
            return Result.error("您没有绑定邮箱或您还为注册/通过审核");
        }
        mailService.getCode(email);
        return Result.success();
    }
}
