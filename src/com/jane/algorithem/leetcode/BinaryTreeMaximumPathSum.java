package com.jane.algorithem.leetcode;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{-1001};
        int value=fun(root,res);
        return Math.max(res[0],value);
    }

    private int fun(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int leftValue = fun(node.left, res);
        int rightValue = fun(node.right, res);
        res[0] = Math.max(res[0], Math.max(Math.max(leftValue, rightValue), leftValue + rightValue)+node.val);
        if (leftValue <= 0 && rightValue <= 0) {
            return node.val;
        } else {
            return Math.max(leftValue, rightValue) + node.val;
        }
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
