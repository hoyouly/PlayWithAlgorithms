package top.hoyouly.playwithalgorithms.chapter4;

import top.hoyouly.playwithalgorithms.chapter3.Queue;

/**
 * 使用栈实现队列
 * 有两个节点，head 节点用来删除，充当队列的尾部
 * tail 节点用来插入，充电工队列的头部
 */

public class LinkedListQueue<E> implements Queue<E> {

    //私有节点
    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node<E> head;
    private Node<E> tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        //入队，就是把这个元素放入到队尾
        if (tail == null) {//链表是空的情况
            //tail 就是新的节点
            tail = new Node<>(e);
            //这个时候head节点和tail节点指向同一个节点
            head = tail;
        } else {//队列不为null，只需要更新尾节点即可
            //tail节点的指向新的节点
            tail.next = new Node<>(e);
            //更新tail 节点位置
            tail = tail.next;
        }
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        //出队，其实就是删除head节点，
        Node<E> delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {//说明队列中没有元素了，那么tail也为null
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue : front  ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.toString() + " -> ");
        }
        sb.append("NULL tail ");
        return sb.toString();
    }
}
