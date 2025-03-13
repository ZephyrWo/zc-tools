package com.zc.ggp.utils.writer;

import cn.idev.excel.FastExcel;
import com.zc.ggp.pojo.entity.DemoData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoWriter {
    // 填充要写入的数据
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
//            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public static void main(String[] args) {
        String fileName = "D:\\Develop\\Project\\zc-tools\\zc-tools-ggp\\source\\demo.xlsx";
        // 创建一个名为“模板”的 sheet 页，并写入数据
        FastExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
}
 
