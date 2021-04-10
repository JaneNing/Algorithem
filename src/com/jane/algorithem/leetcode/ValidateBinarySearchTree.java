package com.jane.algorithem.leetcode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return recursion(root, (long) Integer.MAX_VALUE + 1, (long) Integer.MIN_VALUE - 1);
    }

    private boolean recursion(TreeNode node, long up, long down) {
        if (node == null) return true;
        if (node.val >= up || node.val <= down) return false;
        return recursion(node.left, node.val, down) && recursion(node.right, up, node.val);
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
