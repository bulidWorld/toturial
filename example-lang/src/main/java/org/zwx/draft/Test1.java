package org.zwx.draft;

public class Test1 {

    public static void main(String[] args) {

        int n = 3;

        int denominatorMulti = 1;
        float resultSum = 0F;

        for (int i = 1; i <= n; i++) {
            denominatorMulti = denominatorMulti * i;

            resultSum = resultSum + 1F / denominatorMulti;
        }

        System.out.println(resultSum);

        System.out.println(2 / 5);

    }


}

