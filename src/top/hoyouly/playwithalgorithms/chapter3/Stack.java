package top.hoyouly.playwithalgorithms.chapter3;

public interface Stack<T> {


    void push(T t);

    /**
     * 出栈，并且返回栈顶元素
     */
    T pop();

    /**
     * 查看栈顶元素，
     */
    T peek();

    /**
     * 栈是否为空
     */
    boolean isEmpty();

    /**
     * 得到栈的长度
     */
    int getSize();


}
