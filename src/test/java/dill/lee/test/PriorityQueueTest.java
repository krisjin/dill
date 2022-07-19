package dill.lee.test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * User:krisjin
 * Date:2020-01-07
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        JSONObject.parseObject("", HashMap.class);


        String d = "F068056A-3519-49E2-B4EE-9742AEA25FDA  F068056A-3519-49E2-B4EE-9742AEA25FDA  F068056A-3519-49E2-B4EE-9742AEA25FDA";
        long l = d.getBytes().length * 50000000;
        System.err.println(l/1024/1024);

    }
}
