package top.hoyouly.playwithalgorithms.chapter6;


public class Chap6Test {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 8, 2, 4};
        BST bst = new BST();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        System.out.println("前序遍历：");
        bst.preOrder();

        System.out.println("\n中序遍历：");
        bst.inOrder();
        System.out.println("\n后序遍历：");
        bst.postOrder();
    }


}
