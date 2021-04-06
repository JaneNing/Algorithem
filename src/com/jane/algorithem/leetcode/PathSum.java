package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recursion(root, targetSum, 0, path, res);
        return res;
    }

    private void recursion(TreeNode node, int targetSum, int sum, List<Integer> list, List<List<Integer>> lists) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (targetSum == sum + node.val) {
                ArrayList<Integer> list1 = new ArrayList<>(list);
                list1.add(node.val);
                lists.add(list1);
            }
        } else {
            list.add(node.val);
            recursion(node.left, targetSum, sum + node.val, list, lists);
            recursion(node.right, targetSum, sum + node.val, list, lists);
            list.remove(list.size() - 1);
        }
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
