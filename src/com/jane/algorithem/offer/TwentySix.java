package com.jane.algorithem.offer;

import java.util.LinkedList;
import java.util.Queue;

public class TwentySix {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (B == null) return false;
        if (A == null) return false;
        ((LinkedList<TreeNode>) queue).add(A);
        while (!queue.isEmpty()) {
            TreeNode treeNode = ((LinkedList<TreeNode>) queue).pollFirst();
            if (treeNode.left != null) {
                ((LinkedList<TreeNode>) queue).add(treeNode.left);
            }
            if (treeNode.right != null) {
                ((LinkedList<TreeNode>) queue).add(treeNode.right);
            }
            boolean res = judge(treeNode, B);
            if (res) return true;
        }
        return false;
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (a == null) return b == null;
        else if (b == null) return true;
        if (a.val != b.val) return false;
        return judge(a.left, b.left) && judge(a.right, b.right);
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
