package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThirtyTwo_Second {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> temQueue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = ((LinkedList<TreeNode>) queue).pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    ((LinkedList<TreeNode>) temQueue).add(treeNode.left);
                }
                if (treeNode.right != null) {
                    ((LinkedList<TreeNode>) temQueue).add(treeNode.right);
                }
            }
            res.add(list);
            queue = temQueue;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
