package top.hoyouly.playwithalgorithms.chapter3;

import top.hoyouly.playwithalgorithms.chapter2.Array;

/**
 * 使用动态数组实现栈的功能
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private Array<T> data;

    public ArrayStack() {
        this.data = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.data = new Array<>(capacity);
    }

    @Override
    public void push(T t) {
        data.addLast(t);
    }

    @Override
    public T pop() {
        return data.removeLast();
    }

    @Override
    public T peek() {
        return data.getLast();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack : ");
        sb.append("[ ");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ] top");
        return sb.toString();
    }
}
