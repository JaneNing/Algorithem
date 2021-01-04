package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Integer> path = new ArrayList();
        recursion(original, target, path);
        TreeNode node = cloned;
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == 1) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private boolean recursion(TreeNode node, TreeNode target, List<Integer> list) {
        if (node == target) {
            return true;
        }
        if (node.left != null) {
            list.add(1);
            boolean res = recursion(node.left, target, list);
            if (res) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        if (node.right != null) {
            list.add(2);
            boolean res = recursion(node.right, target, list);
            if (res) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
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
