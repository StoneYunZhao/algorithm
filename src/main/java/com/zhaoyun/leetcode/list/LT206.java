package com.zhaoyun.leetcode.list;

/**
 * 反转列表
 */
public class LT206 {

    /**
     * 就地逆序，遍历，让列表的结点指向其前驱结点，
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur  = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 插入法，遍历列表，每次讲遍历到的结点插入 head 结点之后
     */
    private static void reverseInsert(ListNode head) {
        System.out.println("reverse by insert");
        if (head == null || head.next == null) {
            return;
        }
        ListNode end = head.next;

        for (ListNode current = head.next; current != null; ) {
            ListNode tmp = current.next;
            current.next = head.next;
            head.next = current;
            current = tmp;
        }
        end.next = null;
    }
}
