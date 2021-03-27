package com.jane.algorithem.offer;

public class FiftyFive_First {

    public int maxDepth(TreeNode root) {
        return recursion(root);
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;
        int left = recursion(node.left);
        int right = recursion(node.right);
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
