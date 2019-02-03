package top.hoyouly.playwithalgorithms.chapter13;


import top.hoyouly.playwithalgorithms.chapter12.AVLTree;
import top.hoyouly.playwithalgorithms.chapter7.*;

import java.util.ArrayList;
import java.util.Random;

public class Chap13Test {

    public static void main(String[] args) {
//        testRBTree();
        testAdd1();
    }

    private static void testRBTree() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        RBTree<String, Integer> map = new RBTree<>();
        for (String s : list) {
            if (map.contains(s)) {
                map.set(s, map.get(s) + 1);
            } else {
                map.add(s, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride : " + map.get("pride"));
        System.out.println("Frequency of prejudice :  " + map.get("prejudice"));

    }


    public static void testAdd() {
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> datas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            datas.add(random.nextInt(Integer.MAX_VALUE));
        }
        long startTime = System.currentTimeMillis();

        BSTMap<Integer, Integer> bstMap = new BSTMap<>();

        for (Integer data : datas) {
            bstMap.add(data, data);
        }

        System.out.println("BSTMap  " + ((System.currentTimeMillis() - startTime) / 1000.0));

        startTime = System.currentTimeMillis();

        AVLTree<Integer, Integer> avlTree = new AVLTree<>();

        for (Integer data : datas) {
            avlTree.add(data, data);
        }

        System.out.println("AVLTree  " + ((System.currentTimeMillis() - startTime) / 1000.0));

        startTime = System.currentTimeMillis();

        RBTree<Integer, Integer> rbTree = new RBTree<>();

        for (Integer data : datas) {
            rbTree.add(data, data);
        }

        System.out.println("RBTree  " + ((System.currentTimeMillis() - startTime) / 1000.0));

    }

    public static void testAdd1() {
        int n = 20000000;

        long startTime = System.currentTimeMillis();
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();

        for (int i = 0; i < n; i++) {
            avlTree.add(n, n);
        }

        System.out.println("AVLTree  " + ((System.currentTimeMillis() - startTime) / 1000.0));

        startTime = System.currentTimeMillis();

        RBTree<Integer, Integer> rbTree = new RBTree<>();

        for (int i = 0; i < n; i++) {
            rbTree.add(n, n);
        }

        System.out.println("RBTree  " + ((System.currentTimeMillis() - startTime) / 1000.0));

    }

}
