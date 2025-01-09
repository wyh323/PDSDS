package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class CES_D_BACK {
    private Integer id;//ces_dID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    private String ces_d_1;
    private String ces_d_2;
    private String ces_d_3;
    private String ces_d_4;
    private String ces_d_5;
    private String ces_d_6;
    private String ces_d_7;
    private String ces_d_8;
    private String ces_d_9;
    private String ces_d_10;
    private String ces_d_11;
    private String ces_d_12;
    private String ces_d_13;
    private String ces_d_14;
    private String ces_d_15;
    private String ces_d_16;
    private String ces_d_17;
    private String ces_d_18;
    private String ces_d_19;
    private String ces_d_20;
}
