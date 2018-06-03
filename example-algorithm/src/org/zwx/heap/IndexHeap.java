package org.zwx.heap;

import org.zwx.helper.ArrayHelper;

public class IndexHeap {

    private int[] indexes;

    private int[] data;

    private int count;

    private int capacity;


    public IndexHeap(int capacity) {
        count = 0;
        indexes = new int[capacity];
        this.capacity = capacity;
    }

    public void insert(int k, int newItem) {
        if (k + 1 > capacity) {
            return;
        }
        data[k] = newItem;
        count++;
        indexes[count] = count;
        shiftUp(count);
    }

    public void shiftUp(int i) {
        int parentChild = i / 2;
        while (i > 1 && data[indexes[i]] > data[indexes[parentChild]]) {
            ArrayHelper.swap(indexes, i, parentChild);
            i = parentChild;
            parentChild = i / 2;
        }
    }

    public int extractMax() {
        int max = data[indexes[1]];
        indexes[1] = indexes[count];
        count--;
        shiftDown(1);
        return max;

    }

    public void shiftDown(int k) {
        int leftChildIndex = k * 2;
        int rightChildIndex = 2 * k + 1;
        int parentIndex = k;
    }

      
}
