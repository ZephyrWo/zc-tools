package com.zc.ggp.utils.reader;

import cn.hutool.core.util.EnumUtil;
import cn.idev.excel.EasyExcel;
import cn.idev.excel.FastExcel;
import com.zc.ggp.listener.DemoDataListener;
import com.zc.ggp.listener.MultiTableListener;
import com.zc.ggp.listener.PoolInfoListener;
import com.zc.ggp.pojo.entity.DemoData;
import com.zc.ggp.pojo.entity.LuckyPool;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.util.EnumUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

@SuppressWarnings(value = "all")
public class PoolReader {


    @Test
    public void normalRead(){
        String fileName = "D:\\Develop\\Project\\zc-tools\\zc-tools-ggp\\source\\浪浪奖池.xlsx";
        FastExcel.read(fileName, LuckyPool.class,new PoolInfoListener()).sheet().headRowNumber(3).doRead();
    }

    @Test
    public void demoRead(){
        String fileName = "D:\\Develop\\Project\\zc-tools\\zc-tools-ggp\\source\\demo.xlsx";
        FastExcel.read(fileName, DemoData.class,new DemoDataListener()).sheet("模板").doRead();
    }

    @Test
    public void demoRead3(){
        File file = new File("D:\\Develop\\Project\\zc-tools\\zc-tools-ggp\\source\\鹿可幸运礼物奖池.xlsx");
        MultiTableListener listener = new MultiTableListener();
        // 读取 Excel 文件
        EasyExcel.read(file, listener).sheet().doRead();
        // 处理读取到的多个 table 数据
        List<List<Map<Integer, String>>> tables = listener.getTables();
        for (int i = 0; i < tables.size(); i++) {
            List<Map<Integer, String>> table = tables.get(i);
            System.out.println("Table " + (i + 1) + " data:");
            for (Map<Integer, String> row : table) {
                System.out.println(row);
            }
        }
    }
}
