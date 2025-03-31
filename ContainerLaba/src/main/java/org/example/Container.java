package org.example;

public class Container {

    private static final int INIT_SIZE = 10;

    private int[] items;
    private int size;

    public Container() {
        this.items = new int[INIT_SIZE];
        this.size = 0;
    }


    private void resize() {
        int[] newArray = new int[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
    }

    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds exception");
        }
    }

    public int get(int index) {
        checkOutOfBounds(index);
        return items[index];
    }

    public void add(int element) {
        if (size == items.length) {
            resize();
        }
        items[size++] = element;
    }

    public int remove(int index) {
        checkOutOfBounds(index);
        int removed = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return removed;
    }

    public void clear() {
        items = new int[INIT_SIZE];
        size = 0;
    }

    public int size() {
        return size;
    }


}