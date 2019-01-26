package top.hoyouly.playwithalgorithms.chapter2;


public class Array<T> {

    private T[] data;
    private int size;

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向数组最后添加一个元素
    public void addLast(T e) {
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    //在数组index位置插入指定元素e
    public void add(int index, T e) {

        if (index < 0 || index >= size) {
            new IllegalArgumentException("Add Failed .Require index >=0 and index <= size");
        }

        if (size == data.length) {//扩容
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;//插入后，size需要加一
    }

    private void resize(int length) {
        T[] newData = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            new IllegalArgumentException("Get Failed . Index is Illegal");
        }
        return data[index];
    }

    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            new IllegalArgumentException("Set Failed . Index is Illegal");
        }
        data[index] = e;
    }

    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {//两个对象相比较，使用equals
                return true;
            }
        }
        return false;
    }


    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除index位置的数据，并且返回该数据
    public T remove(int index) {
        if (index < 0 || index >= size) {
            new IllegalArgumentException("Add Failed .Require index >=0 and index <= size");
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;//先减一，才能置空，否则会报错
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {//
            resize(data.length / 2);
        }

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array : size =%d , capacity =%d \n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",  ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
