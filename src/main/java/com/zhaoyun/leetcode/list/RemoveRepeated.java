package com.zhaoyun.leetcode.list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 移除无序列表中重复的项
 */
public final class RemoveRepeated {

    /**
     * 空间换时间的方式，通过一个 HashSet 存储所有的值
     */
    private static void bySet(ListNode head) {
        if (head == null) {
            return;
        }

        Set<Integer> values = new HashSet<>();

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (values.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                values.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 通过两层循环实现, 时间复杂度 O(n^2)
     */
    private static void byTwoLoop(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head.next;
        while (cur != null) {
            Integer data = cur.val;
            int count = 0;
            ListNode innerCur = head.next, pre = head;
            while (innerCur != null) {
                if (Objects.equals(innerCur.val, data)) {
                    count++;
                }

                if (count > 1) {
                    pre.next = innerCur.next;
                    count--;
                } else {
                    pre = innerCur;
                }
                innerCur = innerCur.next;
            }
            cur = cur.next;
        }
    }
}
