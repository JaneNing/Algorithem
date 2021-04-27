package com.jane.algorithem.leetcode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode node) {
        if (node == null) return;
        TreeNode temNode = node.left;
        node.left = node.right;
        node.right = temNode;
        recursion(node.left);
        recursion(node.right);
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
