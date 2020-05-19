package com.zhaoyun.leetcode;

/**
 * 列表每 k 个元素反转
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT25 {

    /**
     * 递归求解
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }

        ListNode h = new ListNode(-1);
        h.next = reverseKGroup(cur, k);
        for (int i = 0; i < k; i++) {
            ListNode tmp = h.next, tmp2 = head.next;;
            h.next = head;
            head.next = tmp;
            head = tmp2;
        }
        return h.next;
    }
}
