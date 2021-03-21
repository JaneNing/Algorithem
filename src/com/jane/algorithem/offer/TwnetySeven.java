package com.jane.algorithem.offer;

public class TwnetySeven {

    public TreeNode mirrorTree(TreeNode root) {
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

        TreeNode(int x) {
            val = x;
        }
    }
}
