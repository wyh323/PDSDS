package com.Tc_traveler.PDSDS.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Advice {
    private int id;
    private String title;//文章标题
    private String photo;//文章封面
    private String content;//文章内容
}
