package com.zhaoyun.leetcode;

/**
 * @author zhaoyun
 * @Date: 2020/4/28
 */
public final class LT1290 {
    public int getDecimalValue(ListNode head) {
        assert head != null;

        int res = head.val;

        head = head.next;
        while (head != null) {
            res = (res << 1) | head.val;
            head = head.next;
        }

        return res;
    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);

        l1.next= l2;
        l2.next = l3;

        int res = new LT1290().getDecimalValue(l1);
        System.out.println(res);
    }
}
