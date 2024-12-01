package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class MADRS {
    private Integer id;//madrsID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    @Min(0)
    @Max(6)
    private Integer madrs_1;
    @Min(0)
    @Max(6)
    private Integer madrs_2;
    @Min(0)
    @Max(6)
    private Integer madrs_3;
    @Min(0)
    @Max(6)
    private Integer madrs_4;
    @Min(0)
    @Max(6)
    private Integer madrs_5;
    @Min(0)
    @Max(6)
    private Integer madrs_6;
    @Min(0)
    @Max(6)
    private Integer madrs_7;
    @Min(0)
    @Max(6)
    private Integer madrs_8;
    @Min(0)
    @Max(6)
    private Integer madrs_9;
    @Min(0)
    @Max(6)
    private Integer madrs_10;
}
