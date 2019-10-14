package com.simplecollection.collection;

import java.util.Arrays;

public class SimpleArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private Object[] elementData;

    private int size;

    public SimpleArrayList() {
        elementData = EMPTY_ELEMENT_DATA;
    }

    public void add(T element) {
        grow(calculateCapacity(elementData, size + 1));
        elementData[size++] = element;
    }

    public void add(int index, T element) {
        rangeCheckForAdd(index);
        grow(calculateCapacity(elementData, size + 1));
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public void remove(int index) {
        rangeCheckForAdd(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
    }

    public void remove(T element) {
        for (int i = 0; i < elementData.length; i++) {
            if(element.equals(elementData[i])){
                remove(i);
            }
        }
    }

    public void set(int index, T element) {
        elementData[index] = element;
    }


    public Object get(int index) {
        return elementData[index];
    }

    public int size() {
        return size;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

}
