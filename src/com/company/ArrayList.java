package com.company;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
    }

    @Override
    public void add(int index, Object item) {
        checkForRange(index);
        extendArrayAsNeeded();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, Object item) {
        checkForRange(index);
        array[index] = item;
    }

    private void checkForRange(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        checkForRange(index);
        return array[index];
    }

    @Override
    public int indexOf(Object item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(item))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        checkForRange(index);
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    @Override
    public List subList(int from, int to) {
        checkForRange(from, to);
        List result = new ArrayList();
        for (int i = from; i < to; i++) {
            result.add(array[i]);
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
        if (to<from) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    @Override
    public boolean add(Object item) {
        extendArrayAsNeeded();
        array[size++] = item;
        return true;
    }

    private void extendArrayAsNeeded() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 3 / 2 + 1];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }
}
