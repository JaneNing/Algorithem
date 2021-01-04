package com.jane.algorithem.leetcode;

public class PseudoPalindromicPathsInABinaryTree {

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) return 0;
        int[] arr = new int[10];
        recursion(root, arr);
        return arr[0];
    }

    private void recursion(TreeNode node, int[] arr) {
        arr[node.val]++;
        if (node.left == null && node.right == null) {
            int num = 0;
            for (int i = 1; i < arr.length; i++) {
                if ((arr[i] & 1) != 0 && num++ != 0) break;
                if (i == arr.length - 1) arr[0]++;
            }
            arr[node.val]--;
            return;
        }
        if (node.left != null) {
            recursion(node.left, arr);
        }
        if (node.right != null) {
            recursion(node.right, arr);
        }
        arr[node.val]--;
    }

    public class TreeNode {
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
