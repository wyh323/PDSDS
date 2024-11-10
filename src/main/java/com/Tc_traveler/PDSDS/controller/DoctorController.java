package com.Tc_traveler.PDSDS.controller;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username,String password){
        Doctor doctor = userService.findByDoctorName(username);
        if(doctor == null){
            userService.registerDoctor(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已经被使用!");
        }
    }
}
