package com.zc.ggp.listener;


import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import cn.idev.excel.exception.ExcelDataConvertException;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.util.ListUtils;
import com.zc.ggp.pojo.entity.LuckyPool;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


//@Slf4j
//public class PoolInfoListener extends AnalysisEventListener<Map<Integer,String>> {
public class PoolInfoListener extends AnalysisEventListener<LuckyPool> {
    private static final int BATCH_COUNT = 5;
    private List<Map<Integer,String>> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

//    @Override
//    public void invoke(Map<Integer, String> data, AnalysisContext context) {
//        System.out.println("解析到一条数据"+ JSONUtil.toJsonStr(data));
////        log.info("解析到一条数据: {}", JSONUtil.toJsonStr(data));
//    }

    @Override
    public void invoke(LuckyPool data, AnalysisContext context) {
        System.out.println("解析到一条奖池配置信息");
        System.out.println(JSONUtil.toJsonStr(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }
    private void saveData(){
//        log.info("存储 {} 条数据", cachedDataList.size());
        System.out.println("存储 {} 条数据" + cachedDataList.size());
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("解析到表头数据");
        System.out.println(JSONUtil.toJsonStr(headMap));
        super.invokeHead(headMap, context);
    }
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        System.out.print("解析失败: ");
        System.out.println(exception.getMessage());
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException ex = (ExcelDataConvertException) exception;
            System.out.println("("+ex.getRowIndex()+","+ex.getColumnIndex()+")");
            System.out.println(JSONUtil.toJsonStr(ex.getCellData()));
        }
    }

}
