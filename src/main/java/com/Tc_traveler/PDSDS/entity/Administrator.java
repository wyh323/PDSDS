package com.Tc_traveler.PDSDS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Administrator {
    @NonNull
    private Integer id;//主键ID
    private String username;//管理员用户名
    @JsonIgnore
    private String password;//管理员密码
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
