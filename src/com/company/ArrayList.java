package com.company;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
    }

    @Override
    public void add(int index, Object item) {
        extendArrayAsNeeded();
            if (array[index]==null) {
                array[index]=item;
                size++;
            }
            else{
                for (int i = size+1; i >= index; i--) {
                    array[i] = array[i - 1];
                }
                array[index] = item;
                size++;
            }
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
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                return 1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item))
                return 1;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        for (Object anArray : array) {
            if (indexOf(anArray) == index) {
                for (int i = index; i < size; i++) {
                    array[i] = array[i + 1];
                }
                size--;
            }
        }
    }

    @Override
    public List subList(int from, int to) {
        List newArray = new ArrayList();
        for (int i = from; i <= to - 1; i++) {
            newArray.add(array[i]);
        }
        return newArray;
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
        for (Object anArray : array) {
            if (anArray.equals(item)) {
                return true;
            }
        }
        return false;
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
            for (int i = 0; i < size; ++i) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public boolean remove(Object item) {
        for (Object anArray : array) {
            if (anArray.equals(item)) {
                for (int i = indexOf(anArray); i < size; i++) {
                    array[i] = array[i + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Object anArray : array) {
            anArray = null;
        }
    }
}
