package com.company;

import java.util.NoSuchElementException;

public class LinkedList implements Deque, List {
    private static class Node {
        Object item;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public void addFirst(Object item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(Object item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public Object getFirst() {
        if (first != null) {
            return first.item;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public Object getLast() {
        if (last != null) {
            return last.item;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public Object pollFirst() {
        if (first != null) {
            Object oldFirst = first.item;
            first = first.next;
            first.prev = null;
            size--;
            return oldFirst;
        } else
            return null;
    }

    @Override
    public Object pollLast() {
        if (last != null) {
            Object oldLast = last.item;
            last = last.prev;
            last.next = null;
            size--;
            return oldLast;
        } else
            return null;
    }

    @Override
    public Object removeFirst() {
        if (first != null) {
            Object oldFirst = first.item;
            first = first.next;
            first.prev = null;
            size--;
            return oldFirst;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public Object removeLast() {
        if (last != null) {
            Object oldLast = last.item;
            last = last.prev;
            last.next = null;
            size--;
            return oldLast;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public int size() {
        /*if (first == null) {
            size = 0;
            return size;
        } else {
            Node newNode = first;
            while (newNode.next != null) {
                size++;
                newNode = newNode.next;
            }
            return size;
        }*/
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public boolean contains(Object item) {
        if (first == null) {
            return false;
        } else {
            Node newNode = first;
            while (newNode.next != null) {
                if (newNode.item.equals(item)) {
                    return true;
                }
                newNode = newNode.next;
            }
            return false;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public boolean add(Object item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        if (first == null) {
            return false;
        } else {
            Node newNode = first;
            while (newNode.next != null) {
                if (newNode.item.equals(item)) {
                    newNode.prev.next = newNode.next;
                    newNode.next.prev = newNode.prev;
                    return true;
                }
                newNode = newNode.next;
            }
            return false;
        }
    }


    @Override
    public void add(int index, Object item) {
        
        Node n = first;
        Node newFirst = new Node();
        int i = 1;
        while (n.next != null) {
            if (i==index){
                n.prev.next =  newFirst;
                newFirst.prev = n.prev;
                newFirst.next = n.next;
                n.next.prev = newFirst;
                break;
            }
            else {
                i++;
                n = n.next;
            }
        }

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


}
