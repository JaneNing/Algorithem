package com.jane.algorithem.offer;

public class TwentyEight {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2 == null;
        if (node2 == null) return false;
        if (node1.val != node2.val) return false;
        return recursion(node1.left, node2.right) && recursion(node1.right, node2.left);
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
