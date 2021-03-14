package com.jane.algorithem.offer;

public class Seventh {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = recursion(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode recursion(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        else if (pl == pr) return new TreeNode(preorder[pl]);
        for (int i = il; i <= ir; i++) {
            if (preorder[pl] == inorder[i]) {
                TreeNode root = new TreeNode(preorder[pl]);
                TreeNode right = recursion(preorder, inorder, i - il + pl + 1, pr, i + 1, ir);
                TreeNode left = recursion(preorder, inorder, pl + 1, i - il + pl, il, i - 1);
                root.right = right;
                root.left = left;
                return root;
            }
        }
        return null;
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
