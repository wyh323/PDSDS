package com.Tc_traveler.PDSDS.entity.table;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class MADRS_BACK {
    private Integer id;//madrsID
    private int patient_id;//病人id
    private String patient_nickname;//病人姓名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer grade;//测试分数
    private String result;//测试结果
    private String madrs_1;
    private String madrs_2;
    private String madrs_3;
    private String madrs_4;
    private String madrs_5;
    private String madrs_6;
    private String madrs_7;
    private String madrs_8;
    private String madrs_9;
    private String madrs_10;
}
