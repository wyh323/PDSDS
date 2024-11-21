package com.Tc_traveler.PDSDS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Doctor {
    private Integer id;//主键ID
    private String username;//医生用户名
    @JsonIgnore
    private String password;//医生密码
    private String nickname;//医生姓名
    private String email;//医生邮箱
    private String pic;//医生头像
    private String address;//上班地点
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
