package ru.sbertech.homework.generics;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private int theSize;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList()
    {
        clear();
    }

    public void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;

        p.data = newVal;
        return oldVal;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;

        if(idx < lower || idx > upper)
            throw new IndexOutOfBoundsException("getNode index: " + idx + "; size: " + size());

        if(idx < size() / 2)
        {
            p = beginMarker.next;
            for(int i = 0; i < idx; i++)
                p = p.next;
        }
        else
        {
            p = endMarker;
            for(int i = size(); i > idx; i--)
                p = p.prev;
        }

        return p;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;

        return p.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        for(T x : this)
            sb.append(x + " ");
        sb.append("]");

        return new String(sb);
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<T> {
        private Node<T> current = beginMarker.next;
        private boolean okToRemove = false;

        public boolean hasNext()
        {
            return current != endMarker;
        }

        public T next()
        {
            if(!hasNext())
                throw new java.util.NoSuchElementException();

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove()
        {
            if(!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
        }
    }

    private static class Node<T> {
        public T data;
        public Node<T>   prev;
        public Node<T>   next;

        public Node(T d, Node<T> p, Node<T> n)
        {
            data = d; prev = p; next = n;
        }
    }
}
