package com.zc.client.http;



import cn.hutool.core.util.ByteUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 游戏相关客户端
 * 游戏下坑位，需要反复定义参数
 * 坑位比较多的情况下，需要手动点击的次数太多，难以看到效果
 * 所以有了想法，通过程序，遍历填写参数发送请求
 * */
public class GameClient {

    @Test
    public void happyFarm() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.get("http://localhost:7777/user/farm/info").newBuilder();
        String queryParam = "t=I&s=b9511c72d18a41bb943db6fc1e86f0ec&t=I&v=1.0.1.1&d=XX iPhone&m=Mi 6&n=wifi&r=cmcc&o=ios10.1&i=fe123ab212cd1321bcam1&h=13798121516&c=WDGG&e=123&L=zh&";
        for (String part : queryParam.split("&")) {
            String[] kv = part.split("=", 2); // 分割 key=value，最多分割 2 次
            if (kv.length == 2) {
                urlBuilder.addQueryParameter(kv[0], kv[1]);
            }
        }
        HttpUrl httpUrl = urlBuilder.build();
        Request.Builder builder = new Request.Builder();
        byte[] requestBody = new byte[10];
        Request.Builder url = builder.post(RequestBody.create(requestBody)).url(httpUrl);
        url.header("X-INF",queryParam);
        Request request = new Request(url);
        Response execute = okHttpClient.newCall(request).execute();
        byte[] bytes = execute.body().byteStream().readAllBytes();
        Charset charset = execute.body().contentType().charset(StandardCharsets.UTF_8);
        String s = new String(bytes, charset);
        System.out.println(s);
    }

    public final String TEST = "http://testapi.langlang88.com";
    public final String DEV = "http://localhost:7777";
    @Test
    public void testHttpUtils(){
        HttpRequest post = HttpUtil.createPost(TEST+"/user/farm/baiting");
        String queryParam = "t=B&s=ff9a4f1b2b084e4c8220da27bf886dcb&t=I&v=1.0.1.1&d=XX iPhone&m=Mi 6&n=wifi&r=cmcc&o=ios10.1&i=fe123ab212cd1321bcam1&h=13798121516&c=WDGG&e=123&L=zh&";
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("X-INF",queryParam);
        HttpRequest httpRequest = post.addHeaders(objectObjectHashMap);
//        String requestBody = JSONUtil.toJsonStr()
//        httpRequest.body();
        for (int i = 0; i < 6; i++) {
            HashMap<String, Integer> requestBodyMap = getRequestBody(i);
            String requestBody = JSONUtil.toJsonStr(requestBodyMap);
            httpRequest.body(requestBody);
            HttpResponse execute = httpRequest.execute();
            byte[] bytes = execute.bodyBytes();
            Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
            String s = new String(bytes, charset);
            System.out.println(s);
        }
    }

    @NotNull
    private static HashMap<String, Integer> getRequestBody(Integer place){
        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("count",100);
        objectObjectHashMap.put("place",place);
        return objectObjectHashMap;
    }

    @Test
    public void testFish(){
        HttpRequest post = HttpUtil.createPost("http://localhost:7777/user/fish/baiting");
        String queryParam = "t=B&s=b9511c72d18a41bb943db6fc1e86f0ec&t=I&v=1.0.1.1&d=XX iPhone&m=Mi 6&n=wifi&r=cmcc&o=ios10.1&i=fe123ab212cd1321bcam1&h=13798121516&c=WDGG&e=123&L=zh&";
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("X-INF",queryParam);
        HttpRequest httpRequest = post.addHeaders(objectObjectHashMap);
//        String requestBody = JSONUtil.toJsonStr()
//        httpRequest.body();
        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> requestBodyMap = getFishRequestBody(i);
            String requestBody = JSONUtil.toJsonStr(requestBodyMap);
            httpRequest.body(requestBody);
            HttpResponse execute = httpRequest.execute();
            byte[] bytes = execute.bodyBytes();
            Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
            String s = new String(bytes, charset);
            System.out.println(s);
        }
    }

    @NotNull
    private static HashMap<String, Object> getFishRequestBody(Integer place){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("count",100);
        objectObjectHashMap.put("newVersion",false);
        objectObjectHashMap.put("place",place);
        return objectObjectHashMap;
    }

}
