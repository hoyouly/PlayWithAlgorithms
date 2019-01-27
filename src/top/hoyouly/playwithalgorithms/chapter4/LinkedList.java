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


    private Node<E> dummyhead;//虚拟节点。也可以成为哨兵节点。
    private int size;

    public LinkedList() {
        dummyhead = new Node(null);
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
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //在链表的index 位置插入一个元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add Fail,  Illgal index");
        }

        Node prev = dummyhead;//虚拟节点
        //找到index前一个节点，因为是从虚拟节点开始的，所以需要遍历index次
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;
        //这一代码就相当于上面三行代码
        prev.next = new Node(e, prev.next);
        size++;//维护变量
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get Fail,  Illgal index");
        }

        //遍历开始是从真正的第一个节点开始的，也就是虚拟节点的下一个，
        Node<E> cur = dummyhead.next;
        // 遍历index，就是要查找的位置
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;

    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set Fail,  Illgal index");
        }

        //遍历开始是从真正的第一个节点开始的，也就是虚拟节点的下一个，
        Node<E> cur = dummyhead.next;
        // 遍历index，就是要查找的位置
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        //遍历开始是从真正的第一个节点开始的，也就是虚拟节点的下一个，
        Node<E> cur = dummyhead.next;
        // 遍历index，就是要查找的位置
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set Fail,  Illgal index");
        }

        Node prv=dummyhead;
        //找到待删除节点的前一个节点
        for (int i = 0; i < index; i++) {
            prv=prv.next;
        }
        //保存待删除的节点
        Node<E> delNode=prv.next;
        //待删除的前一个节点指向待删除的后一个节点
        prv.next=delNode.next;
        //待删除的节点指向null，这样就脱离了链表，也方便GC回收
        delNode.next=null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + " ");
        Node cur = dummyhead.next;
//        while (cur!=null){
//            sb.append(cur.toString()+" -> ");
//            cur=cur.next;
//        }
        for (cur = dummyhead.next; cur != null; cur = cur.next) {
            sb.append(cur.toString() + " -> ");
        }
        sb.append("NULL");
        return sb.toString();

    }
}
