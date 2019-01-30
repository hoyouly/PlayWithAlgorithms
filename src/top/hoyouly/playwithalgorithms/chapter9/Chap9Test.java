package top.hoyouly.playwithalgorithms.chapter9;


import top.hoyouly.playwithalgorithms.chapter8.MaxHeap;

import java.util.Random;

public class Chap9Test {

    public static void main(String[] args) {
        testMaxHeap();
    }

    private static void testMaxHeap() {
        Integer[] arr = new Integer[]{1, 3, 5};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.query(0, 2));
        segmentTree.set(1, 2);
        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.query(0, 2));
    }


}
