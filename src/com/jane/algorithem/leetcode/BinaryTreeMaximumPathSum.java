package com.jane.algorithem.leetcode;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        recursion(root, res);
        return res[0];
    }

    private int recursion(TreeNode node, int[] res) {
        if (node == null) return 0;
        int leftVal = recursion(node.left, res);
        int rightVal = recursion(node.right, res);
        res[0] = Math.max(res[0], Math.max(Math.max(Math.max(node.val, node.val + leftVal), node.val + rightVal), node.val + leftVal + rightVal));
        return Math.max(Math.max(node.val, node.val + leftVal), node.val + rightVal);
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
