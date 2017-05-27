package com.cxp.junit;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CXP on 2016/12/30
 * desc : 测试
 * q978515743@163.com
 */

public class CXPTest {

    @Test
    public void toJosn(){
        Gson gson=new Gson();
        Map<Integer, List<Map<Integer, String>>> mapList = new HashMap<>();
        List<Map<Integer, String>> list=new ArrayList<>();
        Map<Integer, String> map1=new HashMap<>();
        map1.put(1,"学校");
        map1.put(2,"回家");
        Map<Integer, String> map2=new HashMap<>();
        map2.put(3,"北京");
        map2.put(4,"上海");
        list.add(map1);
        list.add(map2);
        mapList.put(5,list);
        Map<Integer, String> map = new HashMap<>();
        for (Map.Entry<Integer, List<Map<Integer, String>>> integerListEntry : mapList.entrySet()) {
            map.put(integerListEntry.getKey(), gson.toJson(integerListEntry.getValue()));
        }

        String json = gson.toJson(map);
        json=json.replace("\"[","[");
        json=json.replace("]\"","]");
        json=json.replace("\\","");
        System.out.println(json);
    }
}
