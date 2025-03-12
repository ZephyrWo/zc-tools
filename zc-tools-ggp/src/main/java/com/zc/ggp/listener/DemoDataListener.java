package com.zc.ggp.listener;


import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import com.zc.ggp.pojo.entity.DemoData;

public class DemoDataListener implements ReadListener<DemoData> {

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("解析了一条数据");
        System.out.println(JSONUtil.toJsonStr(demoData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("解析完成");
        System.out.println(analysisContext);
    }
}