package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {




    //doctor
    @Select("select * from doctor where username=#{username}")
    Doctor findByDoctorName(String username);

    @Insert("insert into doctor(username,password,createtime,updatetime)"+"values (#{username},#{password},now(),now())")
    void addDoctor(String username, String password);

    @Select("select * from doctor")
    List<Doctor> findAllDoctor();

    @Update("update doctor set nickname=#{nickname},email=#{email},updateTime=#{updateTime} where id=#{id}")
    void update(Doctor doctor);

    @Update("update doctor set pic=#{avatarUrl},updateTime=now() where id=#{id}")
    void updateDoctorAvatar(String avatarUrl, int id);




    //patient
    @Select("select * from patient where username=#{username}")
    Patient findByPatientName(String username);

    @Insert("insert into patient(username,password,createtime,updatetime)"+"values (#{patientName},#{md5String},now(),now())")
    void addPatient(String patientName, String md5String);

    @Select("select * from patient where doctor_id=#{id}")
    List<Patient> myPatientsInfo(int id);

    @Update("update patient set nickname=#{nickname},email=#{email},updateTime=#{updateTime}")
    void update(Patient patient);

    @Update("update patient set pic=#{avatarUrl},updateTime=now() where id=#{id}")
    void updatePatientAvatar(String avatarUrl, int id);




    //administrator
    @Select("select * from administrator where username=#{username}")
    Administrator findByAdministratorName(String username);



}
