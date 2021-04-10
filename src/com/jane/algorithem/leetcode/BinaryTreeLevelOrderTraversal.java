package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            LinkedList<TreeNode> temDeque = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    temDeque.add(node.left);
                }
                if (node.right != null) {
                    temDeque.add(node.right);
                }
            }
            deque = temDeque;
            lists.add(list);
        }
        return lists;
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
