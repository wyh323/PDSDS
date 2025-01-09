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

    public MADRS_BACK build() throws Exception {
        MADRS_BACK madrs_back = new MADRS_BACK();
        for(int i=1;i<=10;i++){
            Field field = this.getClass().getDeclaredField("madrs_" + i);
            field.setAccessible(true);
            Integer integer = (Integer) field.get(this);
            Method method = madrs_back.getClass().getMethod("setMadrs_" + i, String.class);
            switch (i){
                case 1:switch (integer){
                    case 0:method.invoke(madrs_back,"无");break;
                    case 1:method.invoke(madrs_back,"介于 无 和 看起来是悲伤的，但能使之高兴一些 之间");break;
                    case 3:method.invoke(madrs_back,"介于 看起来是悲伤的，但能使之高兴一些 和 突出的悲伤忧郁，但其情绪仍可受外界环境影响 之间");break;
                    case 5:method.invoke(madrs_back,"介于 突出的悲伤忧郁，但其情绪仍可受外界环境影响 和 整天抑郁，极度严重 之间");break;
                    case 2:method.invoke(madrs_back,"看起来是悲伤的，但能使之高兴一些");break;
                    case 4:method.invoke(madrs_back,"突出的悲伤忧郁，但其情绪仍可受外界环境影响");break;
                    case 6:method.invoke(madrs_back,"整天抑郁，极度严重");break;
                }break;
                case 2:switch (integer){
                    case 0:method.invoke(madrs_back,"在日常心境中偶有抑郁");break;
                    case 1:method.invoke(madrs_back,"介于 在日常心境中偶有抑郁 和 有抑郁或情绪低沉，但可使之愉快些 之间");break;
                    case 3:method.invoke(madrs_back,"介于 有抑郁或情绪低沉，但可使之愉快些 和 沉湎于抑郁沮丧心境,但环境仍可对心境有些影响 之间");break;
                    case 5:method.invoke(madrs_back,"介于 沉湎于抑郁沮丧心境,但环境仍可对心境有些影响 和 持久不断的深度抑郁沮丧 之间");break;
                    case 2:method.invoke(madrs_back,"有抑郁或情绪低沉，但可使之愉快些");break;
                    case 4:method.invoke(madrs_back,"沉湎于抑郁沮丧心境,但环境仍可对心境有些影响");break;
                    case 6:method.invoke(madrs_back,"持久不断的深度抑郁沮丧");break;
                }break;
                case 3:switch (integer){
                    case 0:method.invoke(madrs_back,"平静，偶有瞬间的紧张");break;
                    case 1:method.invoke(madrs_back,"介于 平静，偶有瞬间的紧张 和 偶有紧张不安及难以言明的不舒服感 之间");break;
                    case 3:method.invoke(madrs_back,"介于 偶有紧张不安及难以言明的不舒服感 和 持久的内心紧张，或间歇呈现的恐惧状态，要花费相当努力方能克制 之间");break;
                    case 5:method.invoke(madrs_back,"介于 持久的内心紧张，或间歇呈现的恐惧状态，要花费相当努力方能克制 和 持续的恐惧和苦恼，极度惊恐 之间");break;
                    case 2:method.invoke(madrs_back,"偶有紧张不安及难以言明的不舒服感");break;
                    case 4:method.invoke(madrs_back,"持久的内心紧张，或间歇呈现的恐惧状态，要花费相当努力方能克制");break;
                    case 6:method.invoke(madrs_back,"持续的恐惧和苦恼，极度惊恐");break;
                }break;
                case 4:switch (integer){
                    case 0:method.invoke(madrs_back,"睡眠如常");break;
                    case 1:method.invoke(madrs_back,"介于 睡眠如常 和 轻度入睡困难，或睡眠较浅，或时睡时醒 之间");break;
                    case 3:method.invoke(madrs_back,"介于 轻度入睡困难，或睡眠较浅，或时睡时醒 和 睡眠减少或睡眠中断2小时以上 之间");break;
                    case 5:method.invoke(madrs_back,"介于 睡眠减少或睡眠中断2小时以上 和 每天睡眠总时间不超过2－3小时 之间");break;
                    case 2:method.invoke(madrs_back,"轻度入睡困难，或睡眠较浅，或时睡时醒");break;
                    case 4:method.invoke(madrs_back,"睡眠减少或睡眠中断2小时以上");break;
                    case 6:method.invoke(madrs_back,"每天睡眠总时间不超过2－3小时");break;
                }break;
                case 5:switch (integer){
                    case 0:method.invoke(madrs_back,"食欲正常或增进");break;
                    case 1:method.invoke(madrs_back,"介于 食欲正常或增进 和 轻度食欲减退 之间");break;
                    case 3:method.invoke(madrs_back,"介于 轻度食欲减退 和 没有食欲，食而无味 之间");break;
                    case 5:method.invoke(madrs_back,"介于 没有食欲，食而无味 和 不愿进食，需他人帮助 之间");break;
                    case 2:method.invoke(madrs_back,"轻度食欲减退");break;
                    case 4:method.invoke(madrs_back,"没有食欲，食而无味");break;
                    case 6:method.invoke(madrs_back,"不愿进食，需他人帮助");break;
                }break;
                case 6:switch (integer){
                    case 0:method.invoke(madrs_back,"无");break;
                    case 1:method.invoke(madrs_back,"介于 无 和 偶有思想集中困难 之间");break;
                    case 3:method.invoke(madrs_back,"介于 偶有思想集中困难 和 思想难以集中，以致干扰阅读或交谈 之间");break;
                    case 5:method.invoke(madrs_back,"介于 思想难以集中，以致干扰阅读或交谈 和 完全不能集中思想，无法阅读 之间");break;
                    case 2:method.invoke(madrs_back,"偶有思想集中困难");break;
                    case 4:method.invoke(madrs_back,"思想难以集中，以致干扰阅读或交谈");break;
                    case 6:method.invoke(madrs_back,"完全不能集中思想，无法阅读");break;
                }break;
                case 7:switch (integer){
                    case 0:method.invoke(madrs_back,"活动发动并无困难，动作不慢");break;
                    case 1:method.invoke(madrs_back,"介于 活动发动并无困难，动作不慢 和 有始动困难 之间");break;
                    case 3:method.invoke(madrs_back,"介于 有始动困难 和 即使简单的日常活动也难以发动，需花很大努力 之间");break;
                    case 5:method.invoke(madrs_back,"介于 即使简单的日常活动也难以发动，需花很大努力 和 完全呈懒散状态，无人帮助什么也干不了 之间");break;
                    case 2:method.invoke(madrs_back,"有始动困难");break;
                    case 4:method.invoke(madrs_back,"即使简单的日常活动也难以发动，需花很大努力");break;
                    case 6:method.invoke(madrs_back,"完全呈懒散状态，无人帮助什么也干不了");break;
                }break;
                case 8:switch (integer){
                    case 0:method.invoke(madrs_back,"对周围的人和物的兴趣正常");break;
                    case 1:method.invoke(madrs_back,"介于 对周围的人和物的兴趣正常 和 对日常趣事的享受减退 之间");break;
                    case 3:method.invoke(madrs_back,"介于 对日常趣事的享受减退 和 对周围不感兴趣，对朋友和熟人缺乏感情 之间");break;
                    case 5:method.invoke(madrs_back,"介于 对周围不感兴趣，对朋友和熟人缺乏感情 和 呈情感麻木状态，不能体验愤怒、悲痛和愉快，对亲友全无感情 之间");break;
                    case 2:method.invoke(madrs_back,"对日常趣事的享受减退");break;
                    case 4:method.invoke(madrs_back,"对周围不感兴趣，对朋友和熟人缺乏感情");break;
                    case 6:method.invoke(madrs_back,"呈情感麻木状态，不能体验愤怒、悲痛和愉快，对亲友全无感情");break;
                }break;
                case 9:switch (integer){
                    case 0:method.invoke(madrs_back,"无");break;
                    case 1:method.invoke(madrs_back,"介于 无 和 时有时无的失败，自责和自卑感 之间");break;
                    case 3:method.invoke(madrs_back,"介于 时有时无的失败，自责和自卑感 和 持久的自责或肯定的但尚近情理的自罪，对前途悲观 之间");break;
                    case 5:method.invoke(madrs_back,"介于 持久的自责或肯定的但尚近情理的自罪，对前途悲观 和 自我毁灭、自我悔恨或感罪恶深重的妄想，荒谬绝伦、难以动摇的自我谴责 之间");break;
                    case 2:method.invoke(madrs_back,"时有时无的失败，自责和自卑感");break;
                    case 4:method.invoke(madrs_back,"持久的自责或肯定的但尚近情理的自罪，对前途悲观");break;
                    case 6:method.invoke(madrs_back,"自我毁灭、自我悔恨或感罪恶深重的妄想，荒谬绝伦、难以动摇的自我谴责");break;
                }break;
                case 10:switch (integer){
                    case 0:method.invoke(madrs_back,"无");break;
                    case 1:method.invoke(madrs_back,"介于 无 和 对生活厌倦，偶有瞬间即逝的自杀念头 之间");break;
                    case 3:method.invoke(madrs_back,"介于 对生活厌倦，偶有瞬间即逝的自杀念头 和 感到不如死了的好，常有自杀念头，认为自杀是一种可能的自我解决的方法，但尚无切实的自杀计划 之间");break;
                    case 5:method.invoke(madrs_back,"介于 感到不如死了的好，常有自杀念头，认为自杀是一种可能的自我解决的方法，但尚无切实的自杀计划 和 已拟适合时机的自杀计划，并积极准备 之间");break;
                    case 2:method.invoke(madrs_back,"对生活厌倦，偶有瞬间即逝的自杀念头");break;
                    case 4:method.invoke(madrs_back,"感到不如死了的好，常有自杀念头，认为自杀是一种可能的自我解决的方法，但尚无切实的自杀计划");break;
                    case 6:method.invoke(madrs_back,"已拟适合时机的自杀计划，并积极准备");break;
                }break;
            }
        }
        return madrs_back;
    }
}
