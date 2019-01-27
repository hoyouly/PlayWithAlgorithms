package top.hoyouly.playwithalgorithms.chapter3;

import top.hoyouly.playwithalgorithms.chapter4.LinkedListQueue;

import java.util.Random;

public class Chap3Main {

    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack();
//
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack.toString());
//        }
//
//        stack.pop();
//        System.out.println(stack.toString());

//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue.toString());
//
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue.toString());
//            }
//        }
//        LoopQueue<Integer> queue = new LoopQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue.toString());
//
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue.toString());
//            }
//        }
        int opCount = 1000000;
        System.out.println("ArrayQueue: " + testQueue(new ArrayQueue(), opCount));
        System.out.println("LoopQueue: " + testQueue(new LoopQueue(), opCount));
        System.out.println("LinkedListQueue: " + testQueue(new LinkedListQueue(), opCount));

    }

    public static double testQueue(Queue queue, int opCount) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        return (System.currentTimeMillis() - start) / 1000.0;
    }

}
