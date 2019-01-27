package top.hoyouly.playwithalgorithms.chapter5;

public class Solution {

    //删除链表中等于给定值 val 的所有节点。 使用递归的方式
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {//求解最基本的问题
            return null;
        }
        //解决更小规模的问题，根据更小问题答案构建出原问题答案
        head.next = removeElements(head.next, val);
        return head.val==val?head.next:head;
    }

    //删除链表中等于给定值 val 的所有节点。 使用虚拟节点处理情况
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }


    //删除链表中等于给定值 val 的所有节点。
    public ListNode removeElements1(ListNode head, int val) {
        //处理  头结点等于val的情况,因为可能头结点删除后的新头结点还有可能等于val，所以需要循环判断
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {//处理完头结点的情况后，可能链表就已经为null了
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
