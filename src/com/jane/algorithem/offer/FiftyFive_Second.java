package com.jane.algorithem.offer;

public class FiftyFive_Second {

    public boolean isBalanced(TreeNode root) {
        int res = recursion(root);
        return res != -1;
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;
        int left = recursion(node.left);
        if (left == -1) return -1;
        int right = recursion(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
