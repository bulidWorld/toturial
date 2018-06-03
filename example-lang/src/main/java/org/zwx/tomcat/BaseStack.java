package org.zwx.tomcat;

public class BaseStack<T> {

    private T t;

    private static final int defaultSize = 20;

    private static final int defaultLimit = -1;

    private int index = -1;

    private int size;

    private final int limit;

    private Object[] objects;


    public BaseStack() {
        this(defaultSize, defaultLimit);
    }

    public BaseStack(int size) {
        this(size, defaultLimit);
    }

    public BaseStack(int size, int limit) {
        this.size = size;
        this.limit = limit;
        objects = new Object[size];
    }


    public synchronized boolean push(T t) {
        if (index == size && limit > size) {
            expand();
        } else if (index == limit && limit != -1) {
            return false;
        }
        objects[index++] = t;
        return true;
    }

    private synchronized void expand() {
        int newSize = 2 * size;

        if (newSize > limit && limit != -1) {
            newSize = limit;
        }

        Object[] newObjects = new Object[newSize];
        System.arraycopy(objects, 0, newObjects, 0, size);
        objects = newObjects;
        size = newSize;
    }

    public synchronized T pop() {
        if (index == -1) {
            return null;
        }
        T result = (T) objects[index--];
        objects[index] = null;
        return result;
    }

}
