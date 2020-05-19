package com.zhaoyun.leetcode;

/**
 * 实现字典树
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT208 {
    private Node root;

    /** Initialize your data structure here. */
    public LT208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] cs = word.toCharArray();
        Node cur = root;
        for (char c: cs) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = searchToEnd(word);
        return n != null && n.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchToEnd(prefix) != null;
    }

    private Node searchToEnd(String s) {
        if (s == null) {
            return null;
        }

        char[] cs = s.toCharArray();
        Node cur= root;
        for (char c: cs) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }

    private static class Node {
        private boolean isEnd;
        private Node[] children;

        private Node() {
            isEnd = false;
            children = new Node[26];
        }
    }
}
