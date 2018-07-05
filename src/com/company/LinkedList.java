package com.company;

import java.util.NoSuchElementException;

public class LinkedList implements List, Deque {
    private Object[] linkList;
    private int size;

    public LinkedList() {
        linkList = new Object[10];
    }


    @Override
    public void addFirst(Object item) {

    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public Object getFirst() {
        if (linkList!=null)
            return linkList[0];
        else
            throw new NoSuchElementException();
    }

    @Override
    public Object getLast() {
        if (linkList!=null)
            return linkList[size-1];
        else
            throw new NoSuchElementException();
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object item) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object item) {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public List subList(int from, int to) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object item) {
        return false;
    }

    @Override
    public boolean add(Object item) {
        return false;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public void clear() {

    }
}
