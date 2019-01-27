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
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    //向root 的为根节点的BST中插入一个元素e,递归算法
    private void add(Node<E> root, E e) {
        //递归终止条件  begin
        if (e.equals(root.e)) {
            //值相等，不做处理，
            return;
        } else if (e.compareTo(root.e) > 0 && root.right == null) {
            //插入的值大于根节点的值并且根节点右节点为null，那么就插入到该根节点的右节点中
            root.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            //插入的值小于根节点的值并且根节点左节点为null，那么就插入到该根节点的左节点中
            root.left = new Node(e);
            size++;
            return;
        }//递归终止条件  end

        //把原问题转换成更小的问题
        if (e.compareTo(root.e) > 0) {
            add(root.right, e);
        } else {
            add(root.left, e);
        }


    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }


    }

}
