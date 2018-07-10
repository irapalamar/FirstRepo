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
            return innerRemoveFirst();
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
            return innerRemoveLast();
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
    public void add(int index, Object item) {
        CheckForRange(index);
        int i = 0;
        Node newFirst = new Node();
        newFirst.item = item;
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            for (Node current = first; current != null; current = current.next) {
                if (i == index) {
                    current.prev.next = newFirst;
                    newFirst.prev = current.prev;
                    newFirst.next = current;
                    current.prev = newFirst;
                    break;
                } else i++;
            }
        }
    }

    private void CheckForRange(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void set(int index, Object item) {
        CheckForRange(index);
        int i = 0;
        for (Node current = first; current != null; current = current.next) {
            if (i == index) {
                current.item = item;
                break;
            } else i++;
        }
    }

    @Override
    public Object get(int index) {
        CheckForRange(index);
        if (index==0){
            return getFirst();
        }
        if (index==size-1){
            return getLast();
        }
        if (index > size / 2) {
            int i = size-1;
            for (Node current = last; current != null; current = current.prev) {
                if (i == index) {
                    return current.item;
                } else
                    i--;
            }
        } else {
            int i = 0;
            for (Node current = first; current != null; current = current.next) {
                if (i == index) {
                    return current.item;
                } else i++;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(Object item) {
        int index = 0;
        if (item == null) {
            for (Node current = first; current != null; current = current.next) {
                if (current.item == null)
                    return index;
                else index++;
            }
        } else {
            for (Node current = first; current != null; current = current.next) {
                index++;
                if (current.item.equals(item))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        return size-1;
    }

    @Override
    public void remove(int index) {
        CheckForRange(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            int i = 0;
            for (Node current = first; current != null; current = current.next) {
                if (i == index) {
                    current.prev.next=current.next;
                    current.next.prev=current.prev;
                    size--;
                }
            }
          }

    }

    @Override
    public List subList(int from, int to) {
        checkForRange(from, to);
        List result = new LinkedList();
        int i=0;
        for (Node current = first; current != null; current = current.next) {
            if ((i>=from)&&(i<=to)){
                result.add(current);
                }
            i++;
            }
        return result;
    }

    private void checkForRange(int from, int to) {
        if ((from < 0) || (from >= size)) {
            throw new IndexOutOfBoundsException();
        }
        if ((to < 0) || (to >= size)) {
            throw new IndexOutOfBoundsException();
        }
        if (to>from) {
            throw new IndexOutOfBoundsException();
        }
    }
}
