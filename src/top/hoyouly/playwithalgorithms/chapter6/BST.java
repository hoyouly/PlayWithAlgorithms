package top.hoyouly.playwithalgorithms.chapter6;

/**
 * BST: Binary Search Tree 二分搜索树
 * <p>
 * 因为存放的元素必须有可比较性，所以对泛型就有限定，必须继承Comparable接口
 * <p>
 * 不包含重复数的BST
 * 每一个节点的值都大于左子数的所有节点的值，
 * 每一个节点的值都小于右子数的所有节点的值
 */

public class BST<E extends Comparable<E>> {

    private class Node<E> {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //一个BTS必须有一个根节点
    private Node<E> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //向root 的为根节点的BST中插入一个元素e,递归算法
    //返回新插入新节点后二分搜索树的跟节点
    private Node<E> add(Node<E> root, E e) {
        //递归终止条件  begin
        if (root == null) {
            return new Node<>(e);
        }
        //递归终止条件  end

        //把原问题转换成更小的问题
        if (e.compareTo(root.e) > 0) {
            //把插入后的结果重新赋值给根节点的右节点，
            root.right = add(root.right, e);
        } else if (e.compareTo(root.e) < 0) {
            //把插入后的结果重新赋值给根节点的坐节点，
            root.left = add(root.left, e);
        }
        return root;


    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }


    }

}
