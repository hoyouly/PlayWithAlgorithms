package top.hoyouly.playwithalgorithms.chapter8;

import top.hoyouly.playwithalgorithms.chapter2.Array;

/**
 * 最大堆
 * 1. 某个节点的值总是不大于其父节点的值,所以泛型 需要继承Comparable
 * 2. 一个完全二叉树
 * 使用动态数组实现
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        //从第一个非叶子节点开始进行下沉操作，直到第一节点，这样下沉后就是一个二叉堆了
        for (int i = getParent(getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }

    }

    public int getSize() {
        return data.getSize();
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }


    //返回完全二叉树的数组表示中，一个索引所表示的的元素对应的父亲节点的索引
    public int getParent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have patenr");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        //先把元素添加到的数组最后位置
        data.addLast(e);

        //开始上浮,上浮的原理就是添加的这个元素和父节点进行比较，如果大于父节点，就交换位置，
        // 继续和父节点比较，直到找到第一个不大于父节点的位置，这个就是该节点的位置,这个叫数据的上浮
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        //k 如果等于0，就说明是最顶端那个，就没有父节点了，
        //只有在该索引对应的元素大于父节点对应的元素时候，才进行交换
        while (k > 0 && data.get(getParent(k)).compareTo(data.get(k)) < 0) {
            //先进行交换
            data.swap(k, getParent(k));
            //然后继续上浮
            k = getParent(k);
        }
    }

    //从堆中取出最大的元素
    //原理： 最大元素肯定是数组头部那个，但是直接取出来，二叉堆就分开了，所以需要先有一个元素占据这个位置，
    //1. 数组先首尾数据交换，这样最大元素就是数组尾部那个，然后删掉不影响二叉堆，但是需要调整新的头部数据的位置，
    //2. 下沉二叉树最顶端数据，找到合适的位置，
    //3. 下沉的测量就是和左右子节点进行对比，和每次都和子节点中最大的进行交换，直到找到一个左右节点都小于的为止
    public E extractMax() {
        //查找最大元素
        E result = findMax();
        //首位数据交换
        data.swap(0, data.getSize() - 1);
        //移除
        data.removeLast();
        siftDown(0);
        return result;

    }

    private void siftDown(int index) {
//        while (index < data.getSize()) {
//            int left = leftChild(index);
//            int right = rightChild(index);
//            if (data.get(left).compareTo(data.get(index)) > 0) {
//                data.swap(index, left);
//                index = left;
//            } else {
//                data.swap(index, right);
//                index = right;
//            }
//        }

        while (leftChild(index) < getSize()) {
            int k = leftChild(index);
            //k+1 肯定就是右节点的索引，如果右节点存在并且值大于左节点，那么k就等于右节点的索引
            if (k + 1 < getSize() && data.get(k + 1).compareTo(data.get(k)) > 0) {
                k = rightChild(index);
            }//到这里，k 就是左右节点最大的那个索引

            //如果查找索引元素对应的值小于左右节点最大的那个值，那么交换
            if (data.get(index).compareTo(data.get(k)) < 0) {
                data.swap(index, k);
                index = k;
            } else {
                //找到位置，直接跳出循环即可。
                break;
            }
        }
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not find Max When heap is empty");
        }
        return data.getFirst();
    }

    //取出最大元素，并且替换成元素e
    //原理就是先保存最大值，然后把e 放到最大值的位置，最后下沉即可
    public E replace(E e) {
        //取出最大值
        E max = findMax();
        //把元素e放入到最大元素的位置，即索引为0的地方
        data.set(0, e);
        //下沉这个元素e
        siftDown(0);
        //返回之前保存的最大值
        return max;
    }


}
