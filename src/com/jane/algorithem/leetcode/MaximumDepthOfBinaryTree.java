package com.jane.algorithem.leetcode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return recursion(root);
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;
        return Math.max(recursion(node.left), recursion(node.right)) + 1;
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
