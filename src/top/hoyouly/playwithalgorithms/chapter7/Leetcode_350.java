package top.hoyouly.playwithalgorithms.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode_350 {

    //给定两个数组，编写一个函数来计算它们的交集。
    //输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    //我们可以不考虑输出结果的顺序。
    public static int[] intersection(int[] nums1, int[] nums2) {
        //使用Map  保存第一个数组，key是数组中的值，value是出现的次数

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        //再次使用Set去重
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map.containsKey(key)) {
                result.add(key);
                Integer value = map.get(key);
                if (value == 1) {
                    map.remove(key);
                } else {
                    map.put(key, value - 1);
                }
            }
        }
        //把集合转为数组
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i]=result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});

    }

}
