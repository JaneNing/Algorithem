package com.jane.algorithem.leetcode;

import java.util.Stack;

public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        recursive(root,new Stack<>());
        return root;
    }

    private void recursive(Node node, Stack<Node> stack) {
        if (node == null) return;
        if (!stack.isEmpty()) {
            stack.pop().next = node;
        }
        recursive(node.left, stack);
        recursive(node.right, stack);
        stack.push(node);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
