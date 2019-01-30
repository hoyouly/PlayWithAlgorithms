package top.hoyouly.playwithalgorithms.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode_215 {
    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5


    /**
     * 1. 把数据存入最大堆中
     * 2. 取出堆中第k个元素
     */
    public int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            if (i == k-1) {
                return maxHeap.extractMax();
            }else {
                i++;
                maxHeap.extractMax();
            }
        }
        throw new IllegalArgumentException("can not find ") ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int largest = new Leetcode_215().findKthLargest(nums, k);
        System.out.println(largest);
    }
}
