package com.zhaoyun.leetcode;

/**
 * 列表元素两两反转
 *
 * @author zhaoyun
 * @Date: 2020/3/14
 */
public final class LT24 {
    /**
     * 将列表以两个为一组分组，后面一组的第二个元素插入到两组之间
     */
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1);
        h.next = head;

        ListNode cur = head, prev = h;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            cur = tmp;
            prev = prev.next.next;
        }

        return h.next;
    }

    /**
     * 递归的方式
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = head.next;
        head.next = swapPairs(head.next.next);
        h.next = head;
        return h;
    }
}
