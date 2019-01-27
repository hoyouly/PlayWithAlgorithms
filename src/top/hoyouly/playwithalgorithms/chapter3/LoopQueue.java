package top.hoyouly.playwithalgorithms.chapter3;

/**
 * 循环队列关键
 * 有两个指针，front 指向队首，tail 指向队尾
 * 判断为null front ==tail
 * 判断已经满  (tail+1)%c==front   c 是指的队列长度
 *
 * @param <T>
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front;
    private int tail;
    private int size;//数组长度，可以通过front 和tail 进行计算，

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        //因为循环队列会浪费一个位置，所以为了得到用户想要的容量，创建的时候就必须多加一个位置
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;//这个容量也是用户创建的时候传递的容量
    }

    @Override
    public boolean isEmpty() {
//        return size == 0;
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(T e) {
        if ((tail + 1) % data.length == front) {//说明数组已满，需要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //TODO 千万不能写成 tail = (tail ++) % data.length 因为这样tail就一直是0
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity + 1];

        for (int i = 0; i < capacity; i++) {
//            newArray[i] = data[front];
//            front = (front++) % data.length;
            //原来的数组首元素位置在front,因为是循环队列，需要进行求余
            newArray[i] = data[(front + i) % data.length];
        }
        //指向新的元素
        data = newArray;
        //从新设置头尾指针
        front = 0;
        tail = size;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            new IllegalArgumentException("Cannot dequeue from an empty queue ");
        }

        T res = data[front];
        data[front] = null;
        //TODO 千万不能写成 front = (front ++) % data.length 因为这样front值一直没变
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {//缩容操作
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            new IllegalArgumentException("Queue is empty ");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + String.format("Array : size =%d , capacity =%d \n", size, getCapacity()));
        sb.append("front [ ");
        //遍历过程，数组是从front 开始的，到tail 结尾，但是因为是循环队列，所以可能front >tail,所以i 是不等于tail
        // i每次加一后需要进行求余操作
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {//说明是最后一个元素
                sb.append(", ");
            }
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
