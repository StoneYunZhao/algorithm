package com.zhaoyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 *
 * @author zhaoyun
 * @Date: 2020/4/19
 */
public final class LT146 {

    public static void main(String[] args) {
        LT146 lru = new LT146(1);
        lru.put(2, 1);
        lru.get(2);
        lru.put(3, 2);
        lru.get(2);
        lru.get(3);
    }


    private int capacity = -1;
    private Node head = null;
    private Node tail = null;

    private Map<Integer, Node> map = null;

    public LT146(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();

        this.tail.next = this.head;
        this.head.prev = this.tail;

        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        deleteNode(node);
        insertNodeBefore(head, node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            if (node.val == value) {
                get(key);
            } else {
                deleteNode(node);
                Node insert = new Node(key, value);
                insertNodeBefore(head, insert);
                map.put(key, insert);
            }
        } else {
            if (capacity-- <= 0) {
                Node delete = tail.next;

                deleteNode(delete);
                map.remove(delete.key);
            }
            Node insert = new Node(key, value);
            insertNodeBefore(head, insert);
            map.put(key, insert);
        }
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    private void insertNodeBefore(Node node, Node insert) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = insert;
        insert.prev = prev;

        insert.next = node;
        node.prev = insert;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private int key;
        private int val;

        private Node() { }

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
