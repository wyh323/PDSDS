package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 抑郁自评量表
 */
@NoArgsConstructor
@Data
public class SDS {
    private Integer id;//sdsID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    @Min(1)
    @Max(4)
    private Integer sds_1;
    @Min(1)
    @Max(4)
    private Integer sds_2;
    @Min(1)
    @Max(4)
    private Integer sds_3;
    @Min(1)
    @Max(4)
    private Integer sds_4;
    @Min(1)
    @Max(4)
    private Integer sds_5;
    @Min(1)
    @Max(4)
    private Integer sds_6;
    @Min(1)
    @Max(4)
    private Integer sds_7;
    @Min(1)
    @Max(4)
    private Integer sds_8;
    @Min(1)
    @Max(4)
    private Integer sds_9;
    @Min(1)
    @Max(4)
    private Integer sds_10;
    @Min(1)
    @Max(4)
    private Integer sds_11;
    @Min(1)
    @Max(4)
    private Integer sds_12;
    @Min(1)
    @Max(4)
    private Integer sds_13;
    @Min(1)
    @Max(4)
    private Integer sds_14;
    @Min(1)
    @Max(4)
    private Integer sds_15;
    @Min(1)
    @Max(4)
    private Integer sds_16;
    @Min(1)
    @Max(4)
    private Integer sds_17;
    @Min(1)
    @Max(4)
    private Integer sds_18;
    @Min(1)
    @Max(4)
    private Integer sds_19;
    @Min(1)
    @Max(4)
    private Integer sds_20;
}
