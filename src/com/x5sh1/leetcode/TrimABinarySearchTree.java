package com.x5sh1.leetcode;

import com.x5sh1.common.TreeNode;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3626/
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < low) {
            return trimBST(root.right, low, high);
        } else if (val > high) {
            return trimBST(root.left, low, high);
        } else {
            TreeNode left = trimBST(root.left, low, val);
            TreeNode right = trimBST(root.right, val, high);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
