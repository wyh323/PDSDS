package com.Tc_traveler.PDSDS.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Mail {
    private Integer id;
    private String email;
    private Integer token;
    private LocalDateTime createTime;
}
