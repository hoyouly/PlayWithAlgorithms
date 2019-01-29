package top.hoyouly.playwithalgorithms.chapter7;

//基于链表实现映射类
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }
    }

    private Node dummpHead;
    private int size;

    public LinkedListMap() {
        dummpHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {//说明不含有这个key 那么直接在头结点添加一个即可
            dummpHead.next = new Node(key, value, dummpHead.next);
            size++;
        } else {
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummpHead.next;
        while (prev != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node deleNode = prev.next;
            prev.next = deleNode.next;
            deleNode.next = null;
            size--;
            return deleNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exit");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 根据key 得到对应的节点node
    private Node getNode(K key) {
        Node cur = dummpHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
