package com.jane.algorithem.leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode node;

    public BinarySearchTreeIterator(TreeNode root) {
        node = root;
    }

    public int next() {
        while (node.left != null && node.left.val >= 0) {
            stack.push(node);
            node = node.left;
        }
        int res = node.val;
        if (node.right != null) {
            stack.push(node.right);
        }
        node.val = -1;
        if (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peek().val == -1) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
            }
        }
        return res;
    }

    public boolean hasNext() {
        return node.val != -1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
