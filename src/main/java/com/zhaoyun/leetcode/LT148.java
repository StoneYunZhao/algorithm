package com.zhaoyun.leetcode;

/**
 * O(nlogn) 的时间复杂度，O(1) 的空间复杂度对单列表排序
 *
 * @author zhaoyun
 * @Date: 2020/2/5
 */
public final class LT148 {
    /**
     * 归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        head = sortList(head);
        second = sortList(second);

        ListNode p, res;
        if (head.val >= second.val) {
            p = second;
            second = second.next;
        } else {
            p = head;
            head = head.next;
        }
        res = p;

        while (head != null && second != null) {
            if (head.val >= second.val) {
                p.next = second;
                second = second.next;
            } else {
                p.next = head;
                head = head.next;
            }
            p = p.next;
        }

        if (head != null) {
            p.next = head;
        }

        if (second != null) {
            p.next = second;
        }

        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
