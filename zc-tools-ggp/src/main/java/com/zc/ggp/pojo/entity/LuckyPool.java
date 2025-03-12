package com.zc.ggp.pojo.entity;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LuckyPool {
    @ExcelProperty("中奖额度")
    private Integer aboutBeans;
    @ExcelProperty("次数")
    private Integer count;
    @ExcelProperty("奖励礼物")
    private String giftName;
//    private String
}
