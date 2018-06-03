package org.zwx.heap;


import org.zwx.helper.ArrayHelper;

public class Heap {

    private int count;

    private int capacity;

    private int[] array;

    private static final int DEFAULT_CAPACITY = 100;


    public Heap() {
        this(DEFAULT_CAPACITY);
    }


    public Heap(int capacity) {
        count = 0;
        array = new int[capacity];
        this.capacity = capacity;
    }

    public Heap(int[] srcArray) {

        int realCapacity = Math.max(srcArray.length, DEFAULT_CAPACITY);
        this.capacity = realCapacity;
        this.array = new int[realCapacity];
        count = 0;
        hipeafy();
    }


    public void shiftUp(int k) {

        int parentIndex = count /2;
        int childIndex = count;

        while (parentIndex > 1 && array[parentIndex] < array[childIndex]) {
            ArrayHelper.swap(array, parentIndex, count);
            childIndex = parentIndex;
            parentIndex = childIndex / 2;
        }

    }

    public void shiftDown(int k) {

        int parentIndex = k;
        int leftChlidIndex = 2 * parentIndex;
        int rightChildIndex = 2 * parentIndex + 1;

        //1.左右孩子节点都有
        //2.只有左孩子节点
        //3.没有孩子节点
        //4.当没有孩子节点的时候退出

        while (leftChlidIndex < count){

            if (array[parentIndex] > array[leftChlidIndex] && array[parentIndex] > array[rightChildIndex]) {
                break;
            }

            //左右节点都有
            if (rightChildIndex <= count) {
                if (array[leftChlidIndex] > array[rightChildIndex]) {
                    ArrayHelper.swap(array, parentIndex, leftChlidIndex);
                    parentIndex = leftChlidIndex;

                } else {
                    ArrayHelper.swap(array, parentIndex, rightChildIndex);
                    parentIndex = rightChildIndex;

                }
            }
            //只有左节点，意味着左节点是最后一个元素
            if (leftChlidIndex == count) {
                if (array[parentIndex] < array[leftChlidIndex]) {
                    ArrayHelper.swap(array, parentIndex, leftChlidIndex);
                    break;
                }
            }

            leftChlidIndex = 2 * parentIndex;
            rightChildIndex = 2 * parentIndex + 1;
        }
    }


    /**
     * 取得最大值
     * @return
     */
    public int extractMax() {

        int value = array[1];
        array[1] = array[count];
        count--;
        shiftDown(1);
        return value;
    }

    /**
     * 插入一个元素
     * @param ele
     */
    public void insert(int ele) {
        count ++;
        array[count] = ele;
        shiftUp(count);
    }


    //第一个元素下标为1
    private void hipeafy() {
        int lastNotChildIndex = array.length / 2;
        for (int i = lastNotChildIndex; i > 0; i--) {
            shiftDown(i);
        }
    }

}
