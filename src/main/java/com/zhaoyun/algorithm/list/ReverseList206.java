package com.zhaoyun.algorithm.list;

/**
 * 将列表反转
 */
public class ReverseList206 {

    /**
     * 就地逆序，遍历，让列表的结点指向其前驱结点，
     */
    private static void reverseInPlace(LNode head) {
        System.out.println("reverse in place");
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        LNode first, second;

        for (first = head.next, second = first.next; second != null; ) {
            LNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        head.next.next = null;
        head.next = first;
    }

    /**
     * 插入法，遍历列表，每次讲遍历到的结点插入 head 结点之后
     */
    private static void reverseInsert(LNode head) {
        System.out.println("reverse by insert");
        if (head == null || head.next == null) {
            return;
        }
        LNode end = head.next;

        for (LNode current = head.next; current != null; ) {
            LNode tmp = current.next;
            current.next = head.next;
            head.next = current;
            current = tmp;
        }
        end.next = null;
    }

    public static void main(String[] args) {
        String  method = "insert";
        method = "inPlace";
        test(0, method);
        test(1, method);
        test(8, method);
    }

    private static void test(int nodeNum, String  method) {
        LNode head = new LNode();
        LNode current = head;

        // 生成带头链表， 0 ~ 7
        for (int i = 0; i < nodeNum; i++) {
            current.next = new LNode(i);
            current = current.next;
        }

        System.out.print("Before reverse: ");
        LNode.printList(head);

        if ("insert".equals(method)) {
            reverseInsert(head);
        } else if ("inPlace".equals(method )) {
            reverseInPlace(head);
        }

        System.out.print("After reversed: ");
        LNode.printList(head);
        System.out.println();
    }
}
