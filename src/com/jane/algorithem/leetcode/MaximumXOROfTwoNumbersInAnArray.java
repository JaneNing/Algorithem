package com.jane.algorithem.leetcode;

public class MaximumXOROfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Node node = root, traceNode = root;
            int temRes = 0;
            for (int j = 30; j >= 0; j--) {
                int bit = (nums[i] >> j) & 1;
                if (bit == 1) {
                    if (node.right == null) {
                        node.right = new Node();
                    }
                    node = node.right;
                    if (traceNode.left != null) {
                        temRes += (1 << j);
                        traceNode = traceNode.left;
                    } else {
                        traceNode = traceNode.right;
                    }
                } else {
                    if (node.left == null) {
                        node.left = new Node();
                    }
                    node = node.left;
                    if (traceNode.right != null) {
                        temRes += (1 << j);
                        traceNode = traceNode.right;
                    } else {
                        traceNode = traceNode.left;
                    }
                }
            }
            res = Math.max(res, temRes);
        }
        return res;
    }

    private class Node {
        Node left, right;
    }
}
