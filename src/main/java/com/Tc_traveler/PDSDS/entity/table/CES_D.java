package com.Tc_traveler.PDSDS.entity.table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public CES_D_BACK build() throws Exception {
        CES_D_BACK ces_d_back = new CES_D_BACK();
        ces_d_back.setId(id);
        ces_d_back.setPatient_id(patient_id);
        ces_d_back.setPatient_nickname(patient_nickname);
        ces_d_back.setCreateTime(createTime);
        ces_d_back.setUpdateTime(updateTime);
        ces_d_back.setGrade(grade);
        ces_d_back.setResult(result);
        for(int i=1;i<=20;i++){
            Field field = this.getClass().getDeclaredField("ces_d_" + i);
            field.setAccessible(true);
            Integer integer = (Integer) field.get(this);
            Method method = ces_d_back.getClass().getMethod("setCes_d_" + i, String.class);
            switch (integer){
                case 0:method.invoke(ces_d_back,"少于一天");break;
                case 1:method.invoke(ces_d_back,"一至两天");break;
                case 2:method.invoke(ces_d_back,"三四天");break;
                case 3:method.invoke(ces_d_back,"五至七天");break;
            }
        }
        return ces_d_back;
    }
}
