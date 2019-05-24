package com.zhaoyun.algorithm.list;


/**
 * 有头结点的列表
 */
public class LNode {
    Integer data;
    LNode next;

    public LNode() {
    }

    public LNode(int data) {
        this.data = data;
    }

    public static void printList(LNode head) {
        if (head == null) {
            System.out.println("null");
        }

        StringBuilder result = new StringBuilder();
        for (LNode current = head; current != null; current = current.next) {
            result.append(current.data).append(" ");
        }
        System.out.println(result);
    }
}
