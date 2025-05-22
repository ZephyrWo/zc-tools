package com.zc.format.utils;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用于工作中常用 JSON 和 String 的 格式标准转换
 * @author ZephyrWo
 * */
public class JSON2String {
    private static final String NEW_LINE_REGEX = "(?<!\\\\r)\\n";

    @Test
    public String jsonStringing(String originalString){
//        String originalString = "[\n" +
//                "{\"el\":\"${extMap.gamePic}\",\"styleType\":\"img\",\"source\":\"remote\"},\n" +
//                "{\"el\":\"${extMap.goodsPic}\",\"styleType\":\"img\",\"source\":\"remote\"},\n" +
//                "{\"el\":\"${nickname}\",\"styleType\":\"basic\",\"color\":\"#88FBBF\"},\n" +
//                "{\"el\":\"${extMap.userSuffixText}\",\"styleType\":\"userOnly\",\"color\":\"#009f1c\"}\n" +
//                "]";

        String replacedString = originalString.replaceAll(NEW_LINE_REGEX, "\\\\r\\\\n");
        System.out.println(replacedString);
        return originalString;
    }
    @Test
    public void jsonStringing2(){
        String originalString = "[\n" +
                "{\"el\":\"${extMap.gamePic}\",\"styleType\":\"img\",\"source\":\"remote\"},\n" +
                "{\"el\":\"${extMap.goodsPic}\",\"styleType\":\"img\",\"source\":\"remote\"},\n" +
                "{\"el\":\"${nickname}\",\"styleType\":\"basic\",\"color\":\"#88FBBF\"},\n" +
                "{\"el\":\"${extMap.userSuffixText}\",\"styleType\":\"userOnly\",\"color\":\"#009f1c\"}\n" +
                "]";
        String replacedString = originalString.replaceAll(NEW_LINE_REGEX, "\\\\r\\\\n");
        replacedString = originalString.replaceAll("\"","\\\\\"");
        System.out.println(replacedString);
    }

}
