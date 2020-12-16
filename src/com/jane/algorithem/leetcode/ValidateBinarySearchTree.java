package com.jane.algorithem.leetcode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, Long.MIN_VALUE, root.val) &&
                isValid(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long left, long right) {
        if (node == null) return true;
        if (node.val <= left || node.val >= right) return false;
        return isValid(node.left, left, Math.min(right, node.val)) && isValid(node.right, Math.max(left, node.val), right);
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
