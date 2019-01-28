package top.hoyouly.playwithalgorithms.chapter7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class LeetCode_804 {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        String[] code = new String[]{".-",
                "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(code[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();


    }
}
