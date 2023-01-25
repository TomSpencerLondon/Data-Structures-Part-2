package com.codewithmosh;

public class Demo {
    private int[] items;
    private int count;

    public Demo(int length) {
        if (length <= 0)
            throw new IllegalArgumentException();

        items = new int[length];
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }

        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index >= count)
            throw new IllegalArgumentException();

        // index: 4
        // i: 5
        // 4 <- 5
        // 5 <- 6
        // 6 <- 7
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;

    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

}
