package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList();
        List<List<Integer>> lists = new ArrayList();
        if(root == null) return lists;
        list.add(root);
        boolean flag = true;
        while(!list.isEmpty()){
            LinkedList<TreeNode> temList = new LinkedList();
            List<Integer> temList1 = new ArrayList<>();
            while(!list.isEmpty()){
                TreeNode temNode = list.pollFirst();
                temList1.add(temNode.val);
                if(flag){
                    if(temNode.right != null){
                        temList.add(temNode.right);
                    }
                    if(temNode.left != null){
                        temList.add(temNode.left);
                    }
                }else{
                    if(temNode.left != null){
                        temList.add(temNode.left);
                    }
                    if(temNode.right != null){
                        temList.add(temNode.right);
                    }
                }
            }
            lists.add(temList1);
            flag = !flag;
            list = temList;
        }
        return lists;
//        Stack<TreeNode> stack = new Stack();
//        int reverse = 0;
//        List<List<Integer>> lists = new ArrayList();
//        if (root == null) {
//            return lists;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            List<Integer> list = new ArrayList();
//            Stack<TreeNode> temStack = new Stack();
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                if (reverse == 0) {
//                    if (node.left != null) {
//                        temStack.push(node.left);
//                    }
//                    if (node.right != null) {
//                        temStack.push(node.right);
//                    }
//                } else {
//                    if (node.right != null) {
//                        temStack.push(node.right);
//                    }
//                    if (node.left != null) {
//                        temStack.push(node.left);
//                    }
//                }
//            }
//            reverse = 1 - reverse;
//            stack = temStack;
//            lists.add(list);
//        }
//        return lists;
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
