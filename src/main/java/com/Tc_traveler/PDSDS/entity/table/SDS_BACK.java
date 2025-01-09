package com.Tc_traveler.PDSDS.entity.table;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class SDS_BACK {
    private Integer id;//sdsID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    private String sds_1;
    private String sds_2;
    private String sds_3;
    private String sds_4;
    private String sds_5;
    private String sds_6;
    private String sds_7;
    private String sds_8;
    private String sds_9;
    private String sds_10;
    private String sds_11;
    private String sds_12;
    private String sds_13;
    private String sds_14;
    private String sds_15;
    private String sds_16;
    private String sds_17;
    private String sds_18;
    private String sds_19;
    private String sds_20;
}
