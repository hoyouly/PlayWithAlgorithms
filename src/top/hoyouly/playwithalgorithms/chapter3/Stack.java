package top.hoyouly.playwithalgorithms.chapter3;

public interface Stack<T> {


    void push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素，
     * @return
     */
    T peek();

    boolean isEmpty();

    int getSize();


}
