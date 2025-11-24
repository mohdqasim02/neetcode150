package datastructure.dynamicArray;

public class DynamicArray {
    int [] arr;
    int size;
    int capacity;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) {
            resize();
        }
        arr[size] = n;
        size += 1;
    }

    public int popback() {
        size--;
        return arr[size];
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int [] newArr = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}

