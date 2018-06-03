package org.zwx.impl;

import org.zwx.api.Sort;

public class MergeSort implements Sort {
    private Integer[] src;

    public MergeSort(Integer[] src) {
        this.src = src;
    }

    @Override
    public Object[] sort() {



        return src;
    }


    //1.没搞清楚递归什么
    //2.递归的参数也要随之递归
    //3.参数值变了，但它代表的意义并没有变
    //拆分并不要求两边的值数量相等
    //递归函数应该要有一个退出条件
    //不要执着于参数值，重点在它所代表的意义
    private void mergeSort(Object[] src, int l, int r){
        if (l >= r) return;
        int m = (l + r) /2;
        sort(src, l, m);
        sort(src, m + 1, r);
        mergeSort(src, l, r);
    }

    private void sort(Object[] src, int l, int r) {
        Object[] newSrc = new Object[r - l + 1];
        for (int i = l; i < r; i++) {
            newSrc[i - l] = src[i];
        }
        for (int i = 0; i < src.length; i++) {

        }

    }
}
