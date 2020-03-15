package com.zhaoyun.leetcode.list;

/**
 * List 是否有环
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT141 {
    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
