package com.zhaoyun.leetcode.list;

/**
 * 合并 k 个排序列表
 *
 * @author zhaoyun
 * @Date: 2020/4/2
 */
public final class LT23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode curNode = head;

        while(true) {
            int curMin = Integer.MAX_VALUE;
            int curIndex = -1;
            boolean got = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (curMin >= lists[i].val) {
                    curMin = lists[i].val;
                    curIndex = i;
                    got = true;
                }
            }

            if (!got) {
                break;
            }

            curNode.next = lists[curIndex];
            curNode = curNode.next;

            lists[curIndex] = lists[curIndex].next;

            curNode.next = null;
        }

        return head.next;
    }

}
