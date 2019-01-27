package top.hoyouly.playwithalgorithms.chapter3;

public interface Queue<T> {

    boolean isEmpty();

    int getSize();

    void enqueue(T t);

    T dequeue();

    //得到队首
    T getFront();

}
