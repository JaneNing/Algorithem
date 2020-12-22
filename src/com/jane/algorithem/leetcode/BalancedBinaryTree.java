package com.jane.algorithem.leetcode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return recrusion(root) != -1;
    }

    private int recrusion(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = recrusion(node.left);
        int rightDepth = recrusion(node.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private class TreeNode {
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
