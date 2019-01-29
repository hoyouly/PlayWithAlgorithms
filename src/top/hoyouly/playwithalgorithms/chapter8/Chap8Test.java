package top.hoyouly.playwithalgorithms.chapter8;


import top.hoyouly.playwithalgorithms.chapter7.*;

import java.util.ArrayList;
import java.util.Random;

public class Chap8Test {

    public static void main(String[] args) {
        testMaxHeap();
    }

    private static void testMaxHeap() {
        int n = 10;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(100));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " - ");
        }

        System.out.println();
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                throw new IllegalArgumentException(" error");
            }
        }
        System.out.println(" finish");
    }


}
