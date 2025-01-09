package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public SDS_BACK build() throws Exception {
        SDS_BACK sds_back = new SDS_BACK();
        sds_back.setId(id);
        sds_back.setPatient_id(patient_id);
        sds_back.setPatient_nickname(patient_nickname);
        sds_back.setCreateTime(createTime);
        sds_back.setUpdateTime(updateTime);
        sds_back.setGrade(grade);
        sds_back.setResult(result);
        for(int i=1;i<=20;i++){
            Field field = this.getClass().getDeclaredField("sds_"+i);
            field.setAccessible(true);
            Integer integer = (Integer) field.get(this);
            Method method = sds_back.getClass().getMethod("setSds_" + i, String.class);
            if (i==1||i==3||i==4||i==7||i==8||i==9||i==10||i==13||i==15||i==19){
                switch (integer){
                    case 1:method.invoke(sds_back,"很少");break;
                    case 2:method.invoke(sds_back,"有时");break;
                    case 3:method.invoke(sds_back,"大局部时间");break;
                    case 4:method.invoke(sds_back,"绝大多数时间");break;
                }
            }else {
                switch (integer){
                    case 1:method.invoke(sds_back,"绝大多数时间");break;
                    case 2:method.invoke(sds_back,"大局部时间");break;
                    case 3:method.invoke(sds_back,"有时");break;
                    case 4:method.invoke(sds_back,"很少");break;
                }
            }
        }
        return sds_back;
    }
}
