package com.company;

import cvs.Version;
import javafx.util.Pair;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

@Version(value = 1,creationDate = "24.07.2018",author = "piy")
public class LinkedList<T> implements Deque<T>, List<T> {

    private static final int NOT_FOUND = -1;



    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>();
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
        Node<T> newNode = new Node<>();
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

    @Override
    public T getLast() {
        checkForNotEmpty();
        return last.item;
    }

    private void checkForNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T pollFirst() {
        if (first != null) {
            return removeNode(first);
        } else
            return null;
    }

    @Override
    public T pollLast() {
        if (last != null) {
            return removeNode(last);
        } else
            return null;
    }

    @Override
    public T removeFirst() {
        if (first != null) {
            return removeNode(first);
        } else
            throw new NoSuchElementException();
    }

    @Override
    public T removeLast() {
        if (last != null) {
            return removeNode(last);
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
        return indexOf(item) != NOT_FOUND;
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
        Node<T> removingNode = getNodeInfo(item).getValue();
        if (removingNode != null) {
            removeNode(removingNode);
            return true;
        } else {
            return false;
        }
    }

    private Pair<Integer, Node<T>> getNodeInfo(T item) {
        if (item == null) {
            Node<T> current = first;
            for (int i = 0; i < size; ++i) {
                if (current.item == null) {
                    return new Pair<>(i, current);
                }
                current = current.next;
            }
        } else {
            Node<T> current = first;
            for (int i = 0; i < size; ++i) {
                if (item.equals(current.item)) {
                    return new Pair<>(i, current);
                }
                current = current.next;
            }
        }
        return new Pair<>(NOT_FOUND, null);
    }


    @Override
    public void add(int index, T item) {
        if (index == size) {
            addLast(item);
            return;
        }

        checkForRange(index);

        Node<T> next = getNode(index);
        Node<T> prev = next.prev;

        Node<T> newNode = new Node<>();
        newNode.item = item;
        newNode.next = next;
        newNode.prev = prev;

        if (prev != null) {
            prev.next = newNode;
        } else {
            first = newNode;
        }
        next.prev = newNode;

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
        getNode(index).item = item;
    }

    @Override
    public T get(int index) {
        checkForRange(index);
        return getNode(index).item;
    }

    @Override
    public int indexOf(T item) {
        return getNodeInfo(item).getKey();
    }

    @Override
    public int lastIndexOf(T item) {
        if (item == null) {
            Node<T> current = last;
            for (int i = size - 1; i >= 0; --i) {
                if (current.item == null) {
                    return i;
                }
                current = current.prev;
            }
        } else {
            Node<T> current = last;
            for (int i = size - 1; i >= 0; --i) {
                if (item.equals(current.item)) {
                    return i;
                }
                current = current.prev;
            }
        }
        return NOT_FOUND;
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

    private Node<T> getNodeFromLeft(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; ++i) {
            current = current.next;
        }
        return current;
    }

    private Node<T> getNodeFromRight(int index) {
        Node<T> current = last;
        for (int i = size - 1; i > index; --i) {
            current = current.prev;
        }
        return current;
    }

    private T removeNode(Node<T> removingNode) {
        T result = removingNode.item;

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

        return result;
    }

    @Override
    public List<T> subList(int from, int to) {
        checkForRange(from, to);
        List<T> result = new ArrayList<>();
        Node<T> current = getNode(from);
        for (int i = from; i < to; ++i) {
            result.add(current.item);
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
