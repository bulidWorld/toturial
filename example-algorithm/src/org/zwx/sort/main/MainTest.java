package org.zwx.main;

import org.zwx.api.Sort;
import org.zwx.helper.TestHelper;
import org.zwx.impl.InsertSort;
import org.zwx.impl.SelectSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {


    public static void main(String[] args) {


        testInsert(TestHelper.getIntArr(5, 1, 2000));

//        testSelection(TestHelper.getIntArr(100000, 1, 500000));


    }


    public static void testSort(Sort sort) {

        Integer[] arrs = (Integer[]) TestHelper.calExeTime(sort);
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arrs);
        System.out.println(list);
    }

    public static void testSelection(Integer[] src) {
        Sort sort = new SelectSort(src);
        testSort(sort);
    }


    public static void testInsert(Integer[] src) {
        Sort sort = new InsertSort(src);
        testSort(sort);
    }
}
