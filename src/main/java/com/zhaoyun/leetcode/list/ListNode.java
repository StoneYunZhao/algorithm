package com.zhaoyun.leetcode.list;


/**
 * 有头结点的列表
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }

        StringBuilder result = new StringBuilder();
        for (ListNode current = head; current != null; current = current.next) {
            result.append(current.val).append(" ");
        }
        System.out.println(result);
    }
}
