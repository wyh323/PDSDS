package com.Tc_traveler.PDSDS.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Patient {
    private Integer id;//患者ID
    private String username;//患者用户名
    private String password;//患者密码
    private String nickname;//患者姓名
    private String email;//患者邮箱
    private String pic;//患者头像
    private String doctor_id;//医生id
    private String doctor_nickname;//医生姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
