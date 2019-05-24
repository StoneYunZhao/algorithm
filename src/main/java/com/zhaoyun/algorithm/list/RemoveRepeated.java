package com.zhaoyun.algorithm.list;

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
    private static void bySet(LNode head) {
        if (head == null) {
            return;
        }

        Set<Integer> values = new HashSet<>();

        LNode pre = head, cur = head.next;
        while (cur != null) {
            if (values.contains(cur.data)) {
                pre.next = cur.next;
            } else {
                values.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 通过两层循环实现, 时间复杂度 O(n^2)
     */
    private static void byTwoLoop(LNode head) {
        if (head == null) {
            return;
        }

        LNode cur = head.next;
        while (cur != null) {
            Integer data = cur.data;
            int count = 0;
            LNode innerCur = head.next, pre = head;
            while (innerCur != null) {
                if (Objects.equals(innerCur.data, data)) {
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


    public static void main(String[] args) {
        int[] data = {1, 3, 1, 5, 5, 5, 7};

        LNode head = new LNode(), cur = head;
        for (int i : data) {
            cur.next = new LNode(i);
            cur = cur.next;
        }

        System.out.print("Before remove repeated: ");
        LNode.printList(head);

//        bySet(head);
        byTwoLoop(head);

        System.out.print("After removed repeated: ");
        LNode.printList(head);
    }
}
