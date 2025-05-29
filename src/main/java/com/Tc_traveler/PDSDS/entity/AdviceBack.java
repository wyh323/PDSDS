package com.Tc_traveler.PDSDS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdviceBack {
    private int id;
    private String title;//文章标题
    private String photo;//文章封面
}
