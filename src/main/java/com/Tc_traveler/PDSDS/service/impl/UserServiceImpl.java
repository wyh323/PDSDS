package com.Tc_traveler.PDSDS.service.impl;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.SDS;
import com.Tc_traveler.PDSDS.mapper.UserMapper;
import com.Tc_traveler.PDSDS.service.UserService;
import com.Tc_traveler.PDSDS.utils.Md5Util;
import com.Tc_traveler.PDSDS.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Doctor findByDoctorName(String username) {
        return userMapper.findByDoctorName(username);
    }

    @Override
    public void registerDoctor(String doctorName, String password) {
        String Md5String = Md5Util.getMD5String(password);
        userMapper.addDoctor(doctorName, Md5String);
    }

    @Override
    public List<Doctor> findAllDoctor() {
        return userMapper.findAllDoctor();
    }

    @Override
    public Patient findByPatientName(String username) {
        return userMapper.findByPatientName(username);
    }

    @Override
    public void registerPatient(String patientName, String password) {
        String Md5String = Md5Util.getMD5String(password);
        userMapper.addPatient(patientName, Md5String);
    }

    @Override
    public Administrator findByAdministratorName(String username) {
        return userMapper.findByAdministratorName(username);
    }

    @Override
    public List<Patient> myPatientsInfo(int id) {
        return userMapper.myPatientsInfo(id);
    }

    @Override
    public void update(Doctor doctor) {
        doctor.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        doctor.setId(id);
        userMapper.update(doctor);
    }

    @Override
    public void update(Patient patient) {
        patient.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        patient.setId(id);
        userMapper.update(patient);
    }

//    @Override
//    public void updateDoctorAvatar(String avatarUrl) {
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        int id = (int) claims.get("id");
//        userMapper.updateDoctorAvatar(avatarUrl,id);
//    }

//    @Override
//    public void updatePatientAvatar(String avatarUrl) {
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        int id = (int) claims.get("id");
//        userMapper.updatePatientAvatar(avatarUrl,id);
//    }

//    @Override
//    public void updateDoctorPwd(String newPwd) {
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        int id = (int) claims.get("id");
//        userMapper.updateDoctorPwd(Md5Util.getMD5String(newPwd),id);
//    }

//    @Override
//    public void updatePatientPwd(String newPwd) {
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        int id =(int) claims.get("id");
//        userMapper.updatePatientPwd(Md5Util.getMD5String(newPwd),id);
//    }

//    @Override
//    public void sds(SDS sds) {
//        Map<String,Object> claims = ThreadLocalUtil.get();
//        int id = (int) claims.get("id");
//        sds.setPatient_id(id);
//        userMapper.sds(sds);
//    }
}
