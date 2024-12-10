package com.Tc_traveler.PDSDS.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Consequence {
    private Integer id;
    private Integer patient_id;
    private String consequence;
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
