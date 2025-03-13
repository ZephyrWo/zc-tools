package com.zc.ggp.listener;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiTableListener extends AnalysisEventListener<Map<Integer, String>> {
    private List<Integer> headerRowNumbers = new ArrayList<>();
    private boolean previousRowEmpty = true;
    private List<List<Map<Integer, String>>> tables = new ArrayList<>();
    private List<Map<Integer, String>> currentTable = new ArrayList<>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        if (data.isEmpty()) {
            previousRowEmpty = true;
            if (!currentTable.isEmpty()) {
                // 遇到空行，当前 table 结束
                tables.add(currentTable);
                currentTable = new ArrayList<>();
            }
        } else {
            int nonEmptyCellCount = 0;
            for (String value : data.values()) {
                if (value != null && !value.trim().isEmpty()) {
                    nonEmptyCellCount++;
                }
            }
            if (nonEmptyCellCount > 0 && previousRowEmpty) {
                // 确认表头行
                headerRowNumbers.add(context.readRowHolder().getRowIndex());
                if (!currentTable.isEmpty()) {
                    // 开始新的 table，先保存上一个 table
                    tables.add(currentTable);
                    currentTable = new ArrayList<>();
                }
            }
            // 将当前行数据添加到当前 table 中
            currentTable.add(data);
            previousRowEmpty = false;
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!currentTable.isEmpty()) {
            // 处理最后一个 table
            tables.add(currentTable);
        }
        System.out.println("All tables processed.");
    }

    public List<List<Map<Integer, String>>> getTables() {
        return tables;
    }
}