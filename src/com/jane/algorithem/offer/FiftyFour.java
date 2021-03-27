package com.jane.algorithem.offer;

public class FiftyFour {

    public int kthLargest(TreeNode root, int k) {
        return recursion(root, new int[]{k});
    }

    private int recursion(TreeNode node, int[] step) {
        if (node == null) return -1;
        int res = recursion(node.right, step);
        if (res != -1) {
            return res;
        }
        if (--step[0] == 0) {
            return node.val;
        }
        res = recursion(node.left, step);
        if (res != -1) {
            return res;
        }
        return -1;
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
