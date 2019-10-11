package com.simplecollection.collection;

public class SimpleLinkedList<E> {

    private Node first;
    private Node last;
    private int size;

    public static class Node<E>{
        private Node<E> prev;
        private Node<E> next;
        private E element;

        public Node(Node<E> prev, Node<E> next, E element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    public void add(E element){
        Node<E> node = new Node<>(last,null,element);
        last = node;
    }

    public void remove(E element){
        if(first == element){
            first.prev = null;
        }else {

        }
    }

    public void set(int index,E element){

    }

    public Object get(int index){
        return null;
    }

    public int size(){
        return size;
    }
}
