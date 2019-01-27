package top.hoyouly.playwithalgorithms.chapter4;

public class LinkedList<E> {

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
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpyt() {
        return size == 0;
    }


    //把节点插入到链表头部
    public void addFirst(E e) {
        head = new Node<>(e, head); //等同于下面三行代码
        //Node node = new Node(e);
        //node.next = head;
        //head = node;
        size++;
    }

    public void addLast(E e) {
        add(size, e );
    }

    //在链表的index 位置插入一个元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add Fail,  Illgal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            int count = 1;
            Node prev = head;
            //找到index前一个节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            //Node node = new Node(e);
            //node.next = prev.next;
            //prev.next = node;
            //这一代码就相当于上面三行代码
            prev.next = new Node(e, prev.next);
            size++;//维护变量
        }
    }

}
