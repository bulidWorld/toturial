package org.zwx.impl;

import org.zwx.api.Sort;

import java.util.Arrays;

public class SelectSort implements Sort {

    private Integer[] src;

    public SelectSort(Integer[] src) {
        this.src = src;
    }

    @Override
    public Object[] sort() {

        for (int i = 0; i < src.length; i++) {

            int minIndex = i;
            for (int j = i; j < src.length; j++) {
                if (src[minIndex] > src[j]) {
                    minIndex = j;
                }
            }

            int temp = src[minIndex];
            src[minIndex] = src[i];
            src[i] = temp;
        }
        return src;
    }


}
