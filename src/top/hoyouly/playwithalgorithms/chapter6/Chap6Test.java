package top.hoyouly.playwithalgorithms.chapter6;


import java.util.Random;

public class Chap6Test {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 8, 2, 4};
        BST<Integer> bst = new BST();
//        for (int i = 0; i < arr.length; i++) {
//            bst.add(arr[i]);
//        }
//        System.out.println("前序遍历 递归：");
//        bst.preOrder();
//        System.out.println("\n前序遍历 非递归：");
//        bst.preOrder();
//
//        System.out.println("\n中序遍历：");
//        bst.inOrder();
//        System.out.println("\n后序遍历：");
//        bst.postOrder();
//        System.out.println("\n层序遍历：");
//        bst.levelOrder();

        Random random = new Random();
        int num = 10;
        for (int i = 0; i < num; i++) {
            bst.add(random.nextInt(1000));
        }
//        System.out.println("removeMin");
//        while (!bst.isEmpty()) {
//            System.out.print(bst.removeMin() + " ");
//        }

        System.out.println("\nremoveMax");
        while (!bst.isEmpty()) {
            System.out.print(bst.removeMax() + " ");
        }
    }


}
