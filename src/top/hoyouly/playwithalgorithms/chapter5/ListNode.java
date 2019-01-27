package top.hoyouly.playwithalgorithms.chapter5;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //使用arr为参数，创建一个链表，当前的listNode为链表的头结点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];//第一个元素的值就赋给当前节点
        ListNode cur = this;//当前结点
        //从第二个位置创建结点，和第一个节点连接起来，就成了一个链表
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}