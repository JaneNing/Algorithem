package com.jane.algorithem.leetcode;

public class MaximumXORWithAnElementFromArray {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Node root = new Node();
        for (int num : nums) {
            Node node = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 1) {
                    if (node.right == null) {
                        node.right = new Node();
                        node = node.right;
                        node.min = num;
                    } else {
                        node = node.right;
                        node.min = Math.min(node.min, num);
                    }
                } else {
                    if (node.left == null) {
                        node.left = new Node();
                        node = node.left;
                        node.min = num;
                    } else {
                        node = node.left;
                        node.min = Math.min(node.min, num);
                    }
                }
            }
        }
        int length = queries.length;
        int[] res = new int[length];
        int index = 0;
        for (int[] query : queries) {
            int x = query[0];
            int limit = query[1];
            Node node = root;
            int num = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (x >> i) & 1;
                if (bit == 1) {
                    if (node.left != null) {
                        num += (1 << i);
                        node = node.left;
                    } else if (node.right == null || node.right.min > limit) {
                        res[index++] = -1;
                        break;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.right != null && node.right.min <= limit) {
                        num += (1 << i);
                        node = node.right;
                    } else if (node.left == null || node.left.min > limit) {
                        res[index++] = -1;
                        break;
                    } else {
                        node = node.left;
                    }
                }
                if (i == 0) {
                    res[index++] = num;
                }
            }
        }
        return res;
    }

    private class Node {
        int min;
        Node left, right;
    }
}
