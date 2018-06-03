package org.zwx.alogthrim;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {
        int[] date = {1,5,2,12,7};


        for (int i = 0; i < date.length; i++) {

            for (int j = 0; j < i; j++) {
                if (date[i] < date[j]) {
                    int temp = date[i];
                    date[i] = date[j];
                    date[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(date));
    }
}
