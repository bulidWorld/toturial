package org.zwx;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleTest {


    @Test
    public void test() {
        System.out.println(String.class.getName());
    }


    @Test
    public void testSort() {
        Map<String, String> map = new HashMap<>();

        map.put("hell", "hell");
        map.put("2", "2");
        map.put("指纹从", "支文侠");

        System.out.println(map);
        System.out.println(map.keySet());
    }
}
