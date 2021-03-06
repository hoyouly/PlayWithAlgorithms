package top.hoyouly.playwithalgorithms.chapter6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Node<E> left;
        Node<E> right;

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
            size++;
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
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }
        //把原问题转换成更小的问题
        if (e.compareTo(node.e) > 0) {
            //把插入后的结果重新赋值给根节点的右节点，
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            //把插入后的结果重新赋值给根节点的坐节点，
            return contains(node.left, e);
        } else {
            return true;
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历，以node为根节点的BST，递归算法
    private void preOrder(Node node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        //大问题化小问题
        System.out.print(node.e + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历的非递归实现  NR ： not recursion
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        //先把根节点压入栈
        stack.push(root);
        //遍历结束的条件就是栈为null
        while (!stack.isEmpty()) {
            //得到栈顶元素
            Node node = stack.pop();
            //因为是前序遍历，所以访问的根节点
            System.out.println(node);
            //因为栈的特性和前序遍历，所以先压入右节点，再压入左节点，
            //这样出栈的时候就先出左节点，再出右节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //层级遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.e + "  ");
            //因为队列的特性FIFO，所以先压入左节点，再压入右节点，
            //这样出队列的时候就先出左节点，再出右节点
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历，以node为根节点的BST，递归算法
    private void inOrder(Node<E> node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        //大问题化小问题
        inOrder(node.left);
        System.out.print(node.e + "  ");
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历，以node为根节点的BST，递归算法
    private void postOrder(Node<E> node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        //大问题化小问题
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + "  ");
    }


    //得到BST的最小值
    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empyt");
        }
        return minimum(root).e;
    }

    //返回以node为根节点的最小值的节点
    private Node<E> minimum(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //得到BST的最大值
    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empyt");
        }
        return maximum(root);
    }

    //返回以node为根节点的最大值的节点
    private E maximum(Node<E> node) {
        if (node.right == null) {
            return node.e;
        }
        return maximum(node.right);
    }

    //删除最小值
    public E removeMin() {
        E ret = minimum();
        //更新root
        root = removeMin(root);
        return ret;
    }

    private Node<E> removeMin(Node<E> node) {
        if (node.left == null) {
            //找到最小值，保留最小值右节点
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            //并且返回这个右节点
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除最大值
    public E removeMax() {
        E ret = maximum();
        //更新root
        root = removeMax(root);
        return ret;
    }

    private Node<E> removeMax(Node<E> node) {
        if (node.right == null) {
            //找到最小值，保留最小值的左节点，这个就是新的节点了
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            //并且返回这个右节点
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e) {
        //找到这个节点

        root = remove(root, e);

    }

    private Node<E> remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//要删除的就是node 节点
            if (node.left == null) {
                Node<E> rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //删除节点左右节点都存在
            //找到后继结点
            Node successor = minimum(node.right);
            //删除最小节点，并且后继结点的右节点指向该删除后的节点
            successor.right = removeMin(node.right);
            //要删除的做节点赋值给后继结点
            successor.left = node.left;
            //删除节点
            node.left = node.right = null;
            //返回这个后继结点
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);

        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树字符串
    private void generateBSTString(Node<E> node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + " null\n");
            return;
        }
        res.append(generateDepthString(depth) + " " + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
