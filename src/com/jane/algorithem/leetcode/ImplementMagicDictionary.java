package com.jane.algorithem.leetcode;

public class ImplementMagicDictionary {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public ImplementMagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = node.list[c - 'a'];
                if (next == null) {
                    next = new Node();
                    node.list[c - 'a'] = next;
                }
                node = next;
            }
            node.word = true;
        }
    }

    public boolean search(String searchWord) {
        return fun(root, searchWord, 0, false);
    }

    private boolean fun(Node node, String word, int i, boolean replace) {
        if (i == word.length()) {
            if (replace && node.word) {
                return true;
            } else {
                return false;
            }
        }
        char c = word.charAt(i);
        if (!replace) {
            for (int j = 0; j < 26; j++) {
                if (c - 'a' == j) continue;
                if (node.list[j] == null) continue;
                boolean res = fun(node.list[j], word, i + 1, true);
                if (res) {
                    return true;
                }
            }
        }
        return node.list[c - 'a'] != null && fun(node.list[c - 'a'], word, i + 1, replace);
    }

    private class Node {
        boolean word = false;
        Node[] list = new Node[26];
    }
}
