package com.zc.format.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在使用CDN时，常常需要拼接地址，查看展示效果
 * @author ZephyrWo
 * */
public class SplicingLinks {
    public Map<String,String> splicing(String prefix, String[] suffixList, String[] nameMap){
        HashMap<String, String> namePicsMap = new HashMap<>();
        for (int i = 0; i < suffixList.length; i++) {
            suffixList[i] = prefix+suffixList[i];
            namePicsMap.put(nameMap[i],suffixList[i]);
        }
        return namePicsMap;
    }
}
