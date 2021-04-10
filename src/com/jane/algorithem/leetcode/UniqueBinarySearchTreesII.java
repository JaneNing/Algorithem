package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int l, int r) {
        if (l > r) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(null);
            return treeNodes;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftBranch = recursion(l, i - 1);
            List<TreeNode> rightBranch = recursion(i + 1, r);
            for (TreeNode leftNode : leftBranch) {
                for (TreeNode rightNode : rightBranch) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
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
