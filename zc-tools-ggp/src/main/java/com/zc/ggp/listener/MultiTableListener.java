package com.zc.ggp.listener;

import cn.hutool.json.JSONUtil;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.zc.ggp.pojo.entity.LuckyPool;
import com.zc.ggp.pojo.entity.dto.LuckyGiftHeadDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiTableListener extends AnalysisEventListener<LuckyPool> {
    private List<LuckyGiftHeadDTO> luckyGiftHeadDTOListList = new ArrayList<>();

    @Override
    public void invoke(LuckyPool data, AnalysisContext context) {
        System.out.println(JSONUtil.toJsonStr(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

        System.out.println("All tables processed.");
    }

    /**
     * Returns the header as a map.Override the current method to receive header data.
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("this is head");
        System.out.println(JSONUtil.toJsonStr(headMap));
    }
}