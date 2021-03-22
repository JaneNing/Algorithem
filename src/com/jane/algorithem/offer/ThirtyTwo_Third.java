package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ThirtyTwo_Third {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return lists;
        stack.push(root);
        boolean flag = true;
        while (!stack.isEmpty()) {
            Stack<TreeNode> temStack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (flag) {
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
            flag = !flag;
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
