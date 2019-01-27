package top.hoyouly.playwithalgorithms.chapter4;

import top.hoyouly.playwithalgorithms.chapter3.Stack;

import java.util.Random;

public class Chap4Main {

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//            System.out.println(linkedList.toString());
//        }
//        linkedList.add(2, 99);
//        System.out.println(linkedList.toString());
//        linkedList.remove(2);
//        System.out.println(linkedList.toString());
//        linkedList.removeFirst();
//        System.out.println(linkedList.toString());
//        linkedList.removeLast();
//        System.out.println(linkedList.toString());

//        LinkedListStack<Integer> stack = new LinkedListStack();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack.toString());
//        }
//
//        stack.pop();
//        System.out.println(stack.toString());

//        int opCount = 10000000;
//        System.out.println("ArrayStack: " + testStack(new ArrayStack(), opCount));
//        System.out.println("LinkedListStack: " + testStack(new LinkedListStack(), opCount));
//        //有可能LinkedListStack 比ArrayStack 还耗时，是因为LinkedListStack有大量的new 操作，这个是很耗时的


        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }
    }


    public static double testStack(Stack stack, int opCount) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        return (System.currentTimeMillis() - start) / 1000.0;
    }

}
