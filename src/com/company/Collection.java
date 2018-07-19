package com.company;

public interface Collection<T> extends Iterable {
    int size();
    boolean isEmpty();
    boolean contains(T item);
    boolean add(T item);
    boolean remove(T item);
    void clear();
}
