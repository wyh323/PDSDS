package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.SDS;
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

    @Update("update doctor set nickname=#{nickname},email=#{email},updateTime=#{updateTime},address=#{address} where id=#{id}")
    void updateDoctor(Doctor doctor);

    @Update("update doctor set pic=#{avatarUrl},updateTime=now() where id=#{id}")
    void updateDoctorAvatar(String avatarUrl, int id);

    @Update("update doctor set password=#{md5String},updateTime=now() where id =#{id}")
    void updateDoctorPwd(String md5String, int id);



    //patient
    @Select("select * from patient where username=#{username}")
    Patient findByPatientName(String username);

    @Insert("insert into patient(username,password,createtime,updatetime)"+"values (#{patientName},#{md5String},now(),now())")
    void addPatient(String patientName, String md5String);

    @Select("select * from patient where doctor_id=#{id}")
    List<Patient> myPatientsInfo(int id);

    @Update("update patient set nickname=#{nickname},email=#{email},updateTime=#{updateTime}")
    void updatePatient(Patient patient);

    @Update("update patient set pic=#{avatarUrl},updateTime=now() where id=#{id}")
    void updatePatientAvatar(String avatarUrl, int id);

    @Update("update patient set password=#{md5String},updateTime=now() where id =#{id}")
    void updatePatientPwd(String md5String, int id);

    @Insert("insert into sds(patient_id,patient_nickname,createTime,updateTime,grade,result,sds_1,sds_2,sds_3,sds_4,sds_5,sds_6,sds_7,sds_8,sds_9,sds_10,sds_11,sds_12,sds_13,sds_14,sds_15,sds_16,sds_17,sds_18,sds_19,sds_20)"+"values (#{patient_id},#{patient_nickname},now(),now(),#{grade},#{result},#{sds_1},#{sds_2},#{sds_3},#{sds_4},#{sds_5},#{sds_6},#{sds_7},#{sds_8},#{sds_9},#{sds_10},#{sds_11},#{sds_12},#{sds_13},#{sds_14},#{sds_15},#{sds_16},#{sds_17},#{sds_18},#{sds_19},#{sds_20})")
    void sds(SDS sds);


    //administrator
    @Select("select * from administrator where username=#{username}")
    Administrator findByAdministratorName(String username);

    //sds
    @Select("select * from sds where patient_id=#{patientId}")
    SDS findSDSByPatientId(int patientId);
}
