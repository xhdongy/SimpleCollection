package com.simplecollection.collection;

public class SimpleArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    private int size;

    public SimpleArrayList() {
        elementData = EMPTY_ELEMENTDATA;
    }

    private void ensureCapacityInternal(T element,int index){
        if(elementData.length < size){
            Object[] newArray = new Object[elementData.length + DEFAULT_CAPACITY];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
        if(index == size){
            elementData[size] = element;
        }else {
            for (int i = size; i > index; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index] = element;
        }
    }

    public void add(T element){
        size ++;
        ensureCapacityInternal(element,size);
    }

    public void add(int index,T element){
        size ++;
        ensureCapacityInternal(element,index);
    }

    public void remove(T element){
        size --;
        for (int i = 0; i < elementData.length; i++) {
            if(elementData[i].equals(element)){
                elementData[i] = elementData[i + 1];
            }
        }
    }

    public void remove(int index){
        size -- ;
        for (int i = index; i < elementData.length; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    public void set(int index,T element){
        elementData[index] = element;
    }


    public Object get(int index){
        return elementData[index];
    }

    public int size(){
        return size;
    }

}
