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
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_1;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_2;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_3;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_4;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_5;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_6;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_7;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_8;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_9;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_10;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_11;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_12;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_13;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_14;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_15;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_16;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_17;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_18;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_19;
    @NotEmpty
    @Min(1)
    @Max(4)
    private Integer sds_20;
}
