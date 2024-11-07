package com.Tc_traveler.PDSDS.service.impl;

import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.mapper.UserMapper;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Doctor findByDoctorName(String username) {
        return userMapper.findByDoctorName(username);
    }

    @Override
    public void registerUser(String username, String password) {
        String Md5String = Md5Util.getMD5String(password);
        userMapper.addUser(username,Md5String);
    }

    @Override
    public Patient findByPatientName(String username) {
        return userMapper.findByPatientName(username);
    }
}
