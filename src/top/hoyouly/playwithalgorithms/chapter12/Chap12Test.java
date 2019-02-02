package top.hoyouly.playwithalgorithms.chapter12;


import top.hoyouly.playwithalgorithms.chapter7.*;

import java.util.ArrayList;
import java.util.Random;

public class Chap12Test {

    public static void main(String[] args) {
        testAVL();
//        testBST();
    }

    private static void testAVL() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());
        long startTime = System.currentTimeMillis();

        AVLTree<String, Integer> map = new AVLTree<>();
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }

        for (String word : words) {
            map.contains(word);
        }
        System.out.println("Frequency of prejudice : AVL  time  " + ((System.currentTimeMillis() - startTime) / 1000.0));
        for (String word : words) {

            map.remove(word);
            if (!map.isBalanced() || !map.isBST()) {
                System.out.println("false.......");
                return;
            }
        }
        System.out.println("dddddddddddd");
    }

    private static void testBST() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());
        long startTime = System.currentTimeMillis();

        BSTMap<String, Integer> map = new BSTMap<>();
        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        for (String word : words) {
            map.contains(word);
        }

        System.out.println("Frequency of prejudice : BST time  " + ((System.currentTimeMillis() - startTime) / 1000.0));


    }


}
