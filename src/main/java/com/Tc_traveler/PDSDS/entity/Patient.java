package com.Tc_traveler.PDSDS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Patient {
    @NonNull
    private Integer id;//患者ID
    private String username;//患者用户名
    @JsonIgnore
    private String password;//患者密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,64}$")
    private String nickname;//患者姓名
    @NotEmpty
    @Email
    private String email;//患者邮箱
    private String pic;//患者头像
    private Integer doctor_id;//医生id
    private String doctor_nickname;//医生姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
