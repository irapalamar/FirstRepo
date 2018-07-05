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
            return innerRemoveFirst();
        } else
            return null;
    }

    @Override
    public Object pollLast() {
        if (last != null) {
            return innerRemoveLast();
        } else
            return null;
    }

    @Override
    public Object removeFirst() {
        if (first != null) {
            innerRemoveFirst();
        } else
            throw new NoSuchElementException();
    }

    private Object innerRemoveFirst() {
        Object oldFirst = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;
        return oldFirst;
    }

    @Override
    public Object removeLast() {
        if (last != null) {
            innerRemoveLast();
        } else
            throw new NoSuchElementException();
    }

    private Object innerRemoveLast() {
        Object oldLast = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size--;
        return oldLast;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        if (first == null) {
            return false;
        }

        for (Node current = first; current != null; current = current.next) {
            if (current.item.equals(item)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    first = current.next;
                    if (first != null) {
                        first.prev = null;
                    }
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    last = current.prev;
                    if (last != null) {
                        last.next = null;
                    }
                }
                return true;
            }
        }
        return false;
    }


    @Override
    // ToDo:
    public void add(int index, Object item) {
        Node n = first;
        Node newFirst = new Node();
        int i = 1;
        while (n.next != null) {
            if (i == index) {
                n.prev.next = newFirst;
                newFirst.prev = n.prev;
                newFirst.next = n.next;
                n.next.prev = newFirst;
                break;
            } else {
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
        if (index > size / 2) {

        } else {

        }
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
