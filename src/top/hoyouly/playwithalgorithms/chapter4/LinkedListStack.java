package top.hoyouly.playwithalgorithms.chapter4;

import top.hoyouly.playwithalgorithms.chapter3.Stack;

/**
 * 使用链表实现栈
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpyt();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(getClass().getSimpleName() + " : top ");
        res.append(list);
        return res.toString();
    }
}
