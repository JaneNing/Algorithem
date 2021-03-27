package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.List;

public class SixtyEight_First {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        find(root, p, list1);
        find(root, q, list2);
        int min = Math.min(list1.size(), list2.size());
        for (int i = 0; i < min; i++) {
            if (list1.get(i) != list2.get(i)) {
                return list1.get(i - 1);
            }
            if (i == min - 1) {
                return list1.get(i);
            }
        }
        return null;
    }

    private boolean find(TreeNode node, TreeNode target, List<TreeNode> list) {
        if (node == null && target == null) return true;
        if (node == null || target == null) return false;
        if (node == target) {
            list.add(node);
            return true;
        }
        list.add(node);
        boolean res = find(node.left, target, list);
        if (res) return true;
        res = find(node.right, target, list);
        if (res) return true;
        list.remove(node);
        return false;
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
