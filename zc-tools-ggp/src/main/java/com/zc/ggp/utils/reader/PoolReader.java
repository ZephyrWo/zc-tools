package com.zc.ggp.utils.reader;

import cn.hutool.core.util.EnumUtil;
import cn.idev.excel.FastExcel;
import com.zc.ggp.listener.DemoDataListener;
import com.zc.ggp.listener.PoolInfoListener;
import com.zc.ggp.pojo.entity.DemoData;
import com.zc.ggp.pojo.entity.LuckyPool;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.util.EnumUtils;

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
}
