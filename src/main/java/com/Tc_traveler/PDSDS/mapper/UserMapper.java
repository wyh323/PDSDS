package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.CES_D;
import com.Tc_traveler.PDSDS.entity.table.MADRS;
import com.Tc_traveler.PDSDS.entity.table.SDS;
import lombok.NonNull;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete from doctor where username=#{username}")
    void deleteDoctor(String username);


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

    @Insert("insert into ces_d(patient_id,patient_nickname,createTime,updateTime,grade,result,ces_d_1,ces_d_2,ces_d_3,ces_d_4,ces_d_5,ces_d_6,ces_d_7,ces_d_8,ces_d_9,ces_d_10,ces_d_11,ces_d_12,ces_d_13,ces_d_14,ces_d_15,ces_d_16,ces_d_17,ces_d_18,ces_d_19,ces_d_20)"+"values (#{patient_id},#{patient_nickname},now(),now(),#{grade},#{result},#{ces_d_1},#{ces_d_2},#{ces_d_3},#{ces_d_4},#{ces_d_5},#{ces_d_6},#{ces_d_7},#{ces_d_8},#{ces_d_9},#{ces_d_10},#{ces_d_11},#{ces_d_12},#{ces_d_13},#{ces_d_14},#{ces_d_15},#{ces_d_16},#{ces_d_17},#{ces_d_18},#{ces_d_19},#{ces_d_20})")
    void ces_d(CES_D cesD);

    @Insert("insert into madrs(patient_id,patient_nickname,createTime,updateTime,grade,result,madrs_1,madrs_2,madrs_3,madrs_4,madrs_5,madrs_6,madrs_7,madrs_8,madrs_9,madrs_10)"+"values (#{patient_id},#{patient_nickname},now(),now(),#{grade},#{result},#{madrs_1},#{madrs_2},#{madrs_3},#{madrs_4},#{madrs_5},#{madrs_6},#{madrs_7},#{madrs_8},#{madrs_9},#{madrs_10})")
    void madrs(MADRS madrs);

    @Select("select * from patient where username=#{username} and doctor_id=#{doctorId}")
    Patient findPatientByUsernameAndDoctorId(String username, Integer doctorId);

    @Delete("delete from patient where username=#{username} and doctor_id=#{doctorId}")
    void deletePatient(String username, Integer doctorId);

    @Select("select * from patient where id=#{id}")
    Patient findByPatientId(int id);

    @Select("select * from patient")
    List<Patient> findAllPatient();

    @Select("select * from patient where doctor_id is null ")
    List<Patient> getLastPatient();

    @Update("update patient set doctor_id=#{doctor_id} where id=#{id}")
    void choosePatient(Patient patient);

    //administrator
    @Select("select * from administrator where username=#{username}")
    Administrator findByAdministratorName(String username);

    //sds
    @Select("select * from sds where patient_id=#{patientId}")
    SDS findSDSByPatientId(int patientId);

    //ces_d
    @Select("select * from ces_d where patient_id=#{patientId}")
    CES_D findCES_DByPatientId(int patientId);

    //madrs
    @Select("select * from madrs where patient_id=#{patientId}")
    MADRS findMADRSByPatientId(int patientId);

    //order(医嘱)
    @Insert("insert into consequence(patient_id,consequence,createTime,updateTime)"+"values(#{id},#{order},now(),now())")
    void addOrder(Integer id, String order);
}
