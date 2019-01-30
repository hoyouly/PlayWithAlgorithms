package top.hoyouly.playwithalgorithms.chapter8;

import java.util.*;
import java.util.PriorityQueue;

public class Leetcode_347 {
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]

    /**
     * 1. 使用map，key 是数组中的元素，value是出现的次数
     * 2. 定义一个内部类，保存数组元素和出现次数，并且继承Comparable接口，根据出现次数设置优先级大小
     * 2. 使用java中自带的优先队列PriorityQueue 默认最小堆,构造函数中可以传递一个比较器，
     * 4. 取出堆中前k 个元素
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int key = nums[i];
            Integer value = map.get(key);
            map.put(key, value == null ? 0 : value + 1);
        }
        //把map中的数据存入带有自定义比较器的优先队列中
        //存入匿名比较器，因为匿名类可以访问map 对象，还是按照频率进行比较的。
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        for (Integer key : map.keySet()) {
            queue.add(key);
        }
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < k) {
            result.add(queue.remove());
            i++;
        }
        System.out.println(result);
        return result;
    }

    //定义一个类，用来存储元素和出现的频率
    private class Frequent {
        int num;
        int freq;//频次

        Frequent(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    private class FrequentComparator implements Comparator<Frequent> {

        @Override
        public int compare(Frequent o1, Frequent o2) {
            return o2.freq - o1.freq;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        new Leetcode_347().topKFrequent(nums, k);
    }
}
