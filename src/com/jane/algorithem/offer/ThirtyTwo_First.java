package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThirtyTwo_First {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> temQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = ((LinkedList<TreeNode>) queue).pollFirst();
                res.add(treeNode.val);
                if (treeNode.left != null) {
                    ((LinkedList<TreeNode>) temQueue).add(treeNode.left);
                }
                if (treeNode.right != null) {
                    ((LinkedList<TreeNode>) temQueue).add(treeNode.right);
                }
            }
            queue = temQueue;
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
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
