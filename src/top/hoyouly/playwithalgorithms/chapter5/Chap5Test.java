package top.hoyouly.playwithalgorithms.chapter5;


public class Chap5Test {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode node = new Solution().removeElements(listNode, 6);
        System.out.println(node);
    }


}
