package com.jane.algorithem.leetcode;

public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] res = new int[1];
        recursion(root, res, low, high);
        return res[0];
    }

    private void recursion(TreeNode node, int[] res, int low, int high) {
        if (node == null) return;
        if (node.val <= high && node.val >= low) res[0] += node.val;
        recursion(node.left, res, low, high);
        recursion(node.right, res, low, high);
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
