package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        int reverse = 0;
        List<List<Integer>> lists = new ArrayList();
        if (root == null) {
            return lists;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList();
            Stack<TreeNode> temStack = new Stack();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (reverse == 0) {
                    if (node.left != null) {
                        temStack.push(node.left);
                    }
                    if (node.right != null) {
                        temStack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        temStack.push(node.right);
                    }
                    if (node.left != null) {
                        temStack.push(node.left);
                    }
                }
            }
            reverse = 1 - reverse;
            stack = temStack;
            lists.add(list);
        }
        return lists;
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
