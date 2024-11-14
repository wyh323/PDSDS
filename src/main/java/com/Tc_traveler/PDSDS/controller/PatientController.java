package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
