package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Doctor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MailMapper {

    @Select("select * from doctor where email=#{email}")
    Doctor findByDoctorEmail(String email);

    @Insert("insert into mail(email,token,createTime) "+"values (#{email},#{token},now())")
    void addMsg(String email, int token);
}
