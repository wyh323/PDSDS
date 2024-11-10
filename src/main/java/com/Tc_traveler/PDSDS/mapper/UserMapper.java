package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from doctor where username=#{username}")
    public Doctor findByDoctorName(String username);

    @Insert("insert into doctor(username,password,createtime,updatetime)"+"values (#{username},#{password},now(),now())")
    public void addDoctor(String username, String password);

    @Select("select * from patient where username=#{username}")
    public Patient findByPatientName(String username);

    @Insert("insert into patient(username,password,createtime,updatetime)"+"values (#{patientName},#{md5String},now(),now())")
    public void addPatient(String patientName, String md5String);
}
