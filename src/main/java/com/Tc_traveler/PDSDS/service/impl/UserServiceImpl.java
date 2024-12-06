package com.Tc_traveler.PDSDS.service.impl;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.CES_D;
import com.Tc_traveler.PDSDS.entity.table.MADRS;
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
        userMapper.updateDoctor(doctor);
    }

    @Override
    public void update(Patient patient) {
        patient.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        patient.setId(id);
        userMapper.updatePatient(patient);
    }

    @Override
    public void updateDoctorAvatar(String avatarUrl) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        userMapper.updateDoctorAvatar(avatarUrl,id);
    }

    @Override
    public void updatePatientAvatar(String avatarUrl) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        userMapper.updatePatientAvatar(avatarUrl,id);
    }

    @Override
    public void updateDoctorPwd(String newPwd) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        userMapper.updateDoctorPwd(Md5Util.getMD5String(newPwd),id);
    }

    @Override
    public void updatePatientPwd(String newPwd) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id =(int) claims.get("id");
        userMapper.updatePatientPwd(Md5Util.getMD5String(newPwd),id);
    }

    @Override
    public void sds(SDS sds) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        sds.setPatient_id(id);
        userMapper.sds(sds);
    }

    @Override
    public SDS findSDSByPatientId(int patient_id) {
        return userMapper.findSDSByPatientId(patient_id);
    }

    @Override
    public SDS findSDSByPatientId() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int patient_id = (int) claims.get("id");
        return userMapper.findSDSByPatientId(patient_id);
    }

    @Override
    public CES_D findCES_DByPatientId() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int patient_id = (int) claims.get("id");
        return userMapper.findCES_DByPatientId(patient_id);
    }

    @Override
    public CES_D findCES_DByPatientId(int patient_id) {
        return userMapper.findCES_DByPatientId(patient_id);
    }

    @Override
    public void ces_d(CES_D cesD) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        cesD.setPatient_id(id);
        userMapper.ces_d(cesD);
    }

    @Override
    public MADRS findMADRSByPatientId() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int patient_id = (int) claims.get("id");
        return userMapper.findMADRSByPatientId(patient_id);
    }

    @Override
    public MADRS findMADRSByPatientId(int patient_id) {
        return userMapper.findMADRSByPatientId(patient_id);
    }

    @Override
    public void madrs(MADRS madrs) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        int id = (int) claims.get("id");
        madrs.setPatient_id(id);
        userMapper.madrs(madrs);
    }

    @Override
    public Patient findPatientByUsernameAndDoctorId(String username, Integer doctorId) {
        return userMapper.findPatientByUsernameAndDoctorId(username,doctorId);
    }

    @Override
    public void deletePatient(String username, Integer doctorId) {
        userMapper.deletePatient(username,doctorId);
    }
}
