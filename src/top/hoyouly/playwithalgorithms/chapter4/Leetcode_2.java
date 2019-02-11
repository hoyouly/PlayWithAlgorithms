package top.hoyouly.playwithalgorithms.chapter4;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Leetcode_2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val + " -> ");
            for (ListNode cur = this.next; cur != null; cur = cur.next) {
                sb.append(cur.val + " -> ");
            }
            sb.append("NULL");
            return sb.toString();

        }
    }

    /**
     * 使用哨兵节点
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummpyHead = new ListNode(0);//哨兵节点
        ListNode node = dummpyHead;

        int carry = 0;//进位值
        while (l1 != null || l2 != null) {
            int i = 0;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            int j = 0;
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode((i + j + carry) % 10);
            carry = (i + j + carry) / 10;
            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        System.out.println("dummpyHead: " + dummpyHead.next.toString());
        return dummpyHead.next;
    }

    /**
     * 思路 两个链表一次取出来一个，然后相加，大于10的话，求余，
     */
    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int v = l1.val + l2.val;
        int value = v % 10;
        int is = v / 10;//是否需要进位

        ListNode result = new ListNode(value);
        ListNode node = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int i = 0;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            int j = 0;
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode((i + j + is) % 10);
            is = (i + j + is) / 10;
            node = node.next;
        }
        if (is != 0) {
            node.next = new ListNode(is);
        }

        System.out.println("result: " + result.toString());
        return result;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        System.out.println(l1.toString());
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
        System.out.println(l2.toString());

        addTwoNumbers(l1, l2);


    }
}
