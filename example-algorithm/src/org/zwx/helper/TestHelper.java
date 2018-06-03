package org.zwx.helper;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.zwx.api.Sort;

import java.util.*;

public class TestHelper {

    public static Object[] calExeTime(Sort sort) {
        long t1 = System.currentTimeMillis();
        Object[] obs = sort.sort();
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
        return obs;
    }


    public static Integer[] getIntArr(int size, int min, int max) {
        Integer[] arr = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = min + random.nextInt(max - min);
        }

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        System.out.println(list);
        return arr;
    }


}
