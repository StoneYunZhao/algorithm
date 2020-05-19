package com.zhaoyun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断列表是否有环，并返回环的起点位置
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT142 {
    /**
     * 用 Set 保存已经访问过的点
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        while (head != null) {
            if(cache.contains(head)) {
                return head;
            }
            cache.add(head);
            head = head.next;
        }

        return null;
    }

    /**
     * 通过推演相遇位置的距离。
     * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
