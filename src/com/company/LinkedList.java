package com.company;

import java.util.NoSuchElementException;

public class LinkedList<T> implements Deque<T>, List<T> {
    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void addFirst(T item) {
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
    public void addLast(T item) {
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
    public T getFirst() {
        checkForNotEmpty();
        return first.item;
    }

    private void checkForNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T getLast() {
        checkForNotEmpty();
        return last.item;
    }

    @Override
    public T pollFirst() {
        if (first != null) {
            T oldFirst = first.item;
            removeNode(getNode(0));
            return oldFirst;
        } else
            return null;
    }

    @Override
    public T pollLast() {
        if (last != null) {
            T oldLast = last.item;
            removeNode(getNode(size-1));
            return oldLast;
        } else
            return null;
    }

    @Override
    public T removeFirst() {
        if (first != null) {
            T oldFirst = first.item;
            removeNode(getNode(0));
            return oldFirst;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public T removeLast() {
        if (last != null) {
            T oldLast = last.item;
            removeNode(getNode(size-1));
            return oldLast;
        } else
            throw new NoSuchElementException();
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
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean add(T item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(T item) {
        if (first != null) {
            removeNode(getNode(indexOf(item)));
            return true;
        }
        return false;
    }


    @Override
    public void add(int index, T item) {
        checkForRange(index);
        Node newFirst = new Node();
        newFirst.item = item;
        Node current = getNode(index);
        current.prev.next = newFirst;
        newFirst.prev = current.prev;
        newFirst.next = current;
        current.prev = newFirst;
        size++;
    }

    private void checkForRange(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void set(int index, T item) {
        checkForRange(index);
        getNode(index).item=item;
       }

    @Override
    public T get(int index) {
        checkForRange(index);
        return getNode(index).item;
    }

    @Override
    public int indexOf(T item) {
        if (item == null) {
            Node current = first;
            for (int i = 0; i < size; ++i) {
                if (current.item == null) {
                    return i;
                }
                current = current.next;
            }
        } else {
            Node current = first;
            for (int i = 0; i < size; ++i) {
                if (item.equals(current.item)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        if (item == null) {
            Node current = last;
            for (int i = size-1; i >= 0; --i) {
                if (current.item == null) {
                    return i;
                }
                current = current.prev;
            }
        } else {
            Node current = last;
            for (int i = size-1; i >= 0; --i) {
                if (item.equals(current.item)) {
                    return i;
                }
                current = current.prev;
            }
        }
        return - 1;
    }

    @Override
    public void remove(int index) {
        checkForRange(index);
        removeNode(getNode(index));
    }

    private Node<T> getNode(int index) {
        if (index < size / 2) {
            return getNodeFromLeft(index);
        } else {
            return getNodeFromRight(index);
        }
    }

    private Node getNodeFromLeft(int index) {
        Node current = first;
        for (int i = 0; i < index; ++i) {
            current = current.next;
        }
        return current;
    }

    private Node getNodeFromRight(int index) {
        Node current = last;
        for (int i = size - 1; i > index; --i) {
            current = current.prev;
        }
        return current;
    }

    private void removeNode(Node removingNode) {
        if (removingNode.prev != null) {
            removingNode.prev.next = removingNode.next;
        } else {
            first = removingNode.next;
        }

        if (removingNode.next != null) {
            removingNode.next.prev = removingNode.prev;
        } else {
            last = removingNode.prev;
        }
        size--;
    }

    @Override
    public List<T> subList(int from, int to) {
        checkForRange(from, to);
        List<T> result = new ArrayList<>();
        Node<T> current = getNode(from);
        for (int i = from; i <= to; ++i) {
            {
                result.add(current.item);
            }
            current = current.next;
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
        if (from > to) {
            throw new IndexOutOfBoundsException();
        }
    }
}
