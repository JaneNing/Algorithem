package com.jane.algorithem.leetcode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        recursion(root);
    }

    private TreeNode recursion(TreeNode node) {
        if (node == null) return null;
        TreeNode leftNode = recursion(node.left);
        if (leftNode == null) {
            TreeNode rightNode = recursion(node.right);
            node.left = null;
            node.right = rightNode;
            return node;
        } else {
            TreeNode temNode = leftNode;
            while (temNode.right != null) {
                temNode = temNode.right;
            }
            temNode.right = recursion(node.right);
            node.right = leftNode;
            node.left = null;
            return node;
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
