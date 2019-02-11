package top.hoyouly.playwithalgorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Leetcode_3 {
    public static void main(String[] args) {
        String s = "abba";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    /**
     * 思路： 一个hashMap,key 是字符，value是该字符对应的索引
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(map.get(c), j);
            }
            result = Math.max(i - j + 1, result);
            //value 之所以使用i+1,是处理只有一个字符的情况，
            map.put(c, i + 1);
        }
        return result;
    }

    public static int lengthOfLongestSubstring_1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        ArrayList<Character> data = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (data.contains(c)) {
                //包含当前字符，取出集合的长度然后和之前的进行比较，取最大值
                result = Math.max(data.size(), result);
                //删除掉包含该字符之前所有的字符
                for (int i1 = 0; i1 < data.size(); ) {
                    if (!data.get(i1).equals(c)) {
                        data.remove(i1);
                    } else {
                        data.remove(i1);
                        break;
                    }
                }
            }
            data.add(c);
        }
        result = Math.max(data.size(), result);
        return result;
    }
}
