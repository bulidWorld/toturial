package org.zwx.impl;

import org.zwx.api.Sort;

public class InsertSort implements Sort {

    private Integer[] src;


    public InsertSort(Integer[] src) {
        this.src = src;
    }


    //排序算法怎么写？
    //把要写的东西先用自己的语言组织清楚，再用计算机语言来表达
    //若是理解都不到位，怎么给他写出来？？？
    //插入，什么是插入
    //先往后排，不管占坑的是谁，排完之后再占坑
    @Override
    public Object[] sort(){

        //赋值，暂存，插入
        for (int i = 1; i < src.length; i++) {
            int e = src[i];//变化的元素先提取出来
            int j = i;
            for (j = i; j > 0 ; j--) {
                if (src[j - 1] < e) break;
                //数组之间的赋值操作约等于交换位置
                src[j] = src[j - 1];//覆盖了变化元素的值
                // s[0], s[1], s[2], s[3]
                //j=3  s[3] = s[2]
                //j=2 s[2] = s[1]
                //j=1 s[1] = s[0]

            }
            //最后再把暂存的值插入到真实的位置
            src[j] = e;

    //下面这种写法为什么会慢了点？
    //过多的赋值操作？
//            for (int j = i  ; j > 0; j--) {
//                int prev = j - 1;
//                if (src[prev] < src[j]) {
//                    break;
//                }
//                if (src[prev] > src[j]){
//                    int temp = src[prev];
//                    src[prev] = src[j];
//                    src[j] = temp;
//                }
//            }
        }

        return src;
    }
}
