package top.hoyouly.playwithalgorithms;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int i = 8;
        i = ++i;
        System.out.println(i);
    }

    public static double test() {

        Random random=new Random();
        long startTime = System.currentTimeMillis();


        return (System.currentTimeMillis() - startTime) / 1000.0;
    }
}
