package com.zc.ggp.pojo.entity;

import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.*;

import java.util.Date;
import java.util.Objects;

// 示例数据类
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
//    @ExcelProperty("日期标题")
//    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    @ExcelIgnore
    private String ignore;
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }


    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DemoData demoData = (DemoData) o;
//        return Objects.equals(string, demoData.string) && Objects.equals(date, demoData.date) && Objects.equals(doubleData, demoData.doubleData) && Objects.equals(ignore, demoData.ignore);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(string, date, doubleData, ignore);
//    }
}
