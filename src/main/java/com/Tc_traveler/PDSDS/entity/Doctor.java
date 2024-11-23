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
public class Doctor {
    @NonNull
    private Integer id;//主键ID
    private String username;//医生用户名
    @JsonIgnore
    private String password;//医生密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,64}$")
    private String nickname;//医生姓名
    @NotEmpty
    @Email
    private String email;//医生邮箱
    private String pic;//医生头像
    private String address;//上班地点
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
