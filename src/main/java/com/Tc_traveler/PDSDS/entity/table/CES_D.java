package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class CES_D {
    private Integer id;//ces_dID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    @Min(0)
    @Max(3)
    private Integer ces_d_1;
    @Min(0)
    @Max(3)
    private Integer ces_d_2;
    @Min(0)
    @Max(3)
    private Integer ces_d_3;
    @Min(0)
    @Max(3)
    private Integer ces_d_4;
    @Min(0)
    @Max(3)
    private Integer ces_d_5;
    @Min(0)
    @Max(3)
    private Integer ces_d_6;
    @Min(0)
    @Max(3)
    private Integer ces_d_7;
    @Min(0)
    @Max(3)
    private Integer ces_d_8;
    @Min(0)
    @Max(3)
    private Integer ces_d_9;
    @Min(0)
    @Max(3)
    private Integer ces_d_10;
    @Min(0)
    @Max(3)
    private Integer ces_d_11;
    @Min(0)
    @Max(3)
    private Integer ces_d_12;
    @Min(0)
    @Max(3)
    private Integer ces_d_13;
    @Min(0)
    @Max(3)
    private Integer ces_d_14;
    @Min(0)
    @Max(3)
    private Integer ces_d_15;
    @Min(0)
    @Max(3)
    private Integer ces_d_16;
    @Min(0)
    @Max(3)
    private Integer ces_d_17;
    @Min(0)
    @Max(3)
    private Integer ces_d_18;
    @Min(0)
    @Max(3)
    private Integer ces_d_19;
    @Min(0)
    @Max(3)
    private Integer ces_d_20;
}
