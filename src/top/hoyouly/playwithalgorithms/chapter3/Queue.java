package top.hoyouly.playwithalgorithms.chapter3;

public interface Queue<T> {

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();

    /**
     * 得到队列的长度
     */
    int getSize();

    /**
     * 入队列
     */
    void enqueue(T t);

    /**
     * 出队列
     */
    T dequeue();

    /**
     * 得到队首元素
     */
    T getFront();

}
