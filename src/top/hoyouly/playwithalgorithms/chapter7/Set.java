package top.hoyouly.playwithalgorithms.chapter7;

public interface Set<E> {

    void add(E e);//不能添加重复的

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
