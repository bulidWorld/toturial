package org.zwx.test;


public class Test1
{

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = 4;
        swap(arr, 4);
    }


    public static void swap(int[] arr, int n) {

        int length = arr.length;
        int last = arr[length - 1];
        int i = 1;
        for (i = 1; i < n; i++) {
            arr[length - i] = arr[length - i - 1];
            //s[6] = s[5];
            //s[5] = s[4]
            //s[4] = s[6]
        }
        arr[length - i] = last;

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ",");
        }
    }
}
