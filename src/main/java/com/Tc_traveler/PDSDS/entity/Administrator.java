package com.Tc_traveler.PDSDS.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Administrator {
    private Integer id;//主键ID
    private String username;//管理员用户名
    private String password;//管理员密码
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
