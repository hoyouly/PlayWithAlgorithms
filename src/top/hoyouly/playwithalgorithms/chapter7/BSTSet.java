package top.hoyouly.playwithalgorithms.chapter7;

import top.hoyouly.playwithalgorithms.chapter6.BST;

/**
 * 基于BST实现的集合set
 * @param <E>
 */
public class BSTSet<E extends Comparable> implements Set<E> {

    private BST bst;

    public BSTSet() {
        bst=new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
