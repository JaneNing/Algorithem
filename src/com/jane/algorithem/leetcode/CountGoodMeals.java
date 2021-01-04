package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class CountGoodMeals {

    public int countPairs(int[] deliciousness) {
        Node root = new Node();
        long res = 0;
        int zeroNum = 0;
        Arrays.sort(deliciousness);
        for (int i = 0; i < deliciousness.length; i++) {
            int num = deliciousness[i];
            long temRes = 0;
            if (num == 0) {
                zeroNum++;
                continue;
            }
            int base = 0;
            while ((1 << base) <= num) {
                if ((1 << base) == num) {
                    temRes += zeroNum;
                    temRes %= (1e9 + 7);
                }
                base++;
            }
            int tem = (1 << base) - num;
            String s = Integer.toBinaryString(tem);
            Node trackNode = root;
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (c == '0') {
                    if (trackNode != null) {
                        trackNode = trackNode.left;
                    }
                } else {
                    if (trackNode != null) {
                        trackNode = trackNode.right;
                    }
                }
            }
            if (trackNode != null) {
                temRes += trackNode.num;
                temRes %= (1e9 + 7);
            }
            res += temRes;
            res %= (1e9 + 7);
            String ss = Integer.toBinaryString(num);
            Node node = root;
            for (int j = ss.length() - 1; j >= 0; j--) {
                char c = ss.charAt(j);
                if (c == '0') {
                    if (node.left == null) {
                        node.left = new Node();
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Node();
                    }
                    node = node.right;
                }
            }
            node.num++;
        }
        res = (res % (long) (1e9 + 7));
        return (int) res;
    }

    private class Node {
        int num = 0;
        Node left, right;
    }
}
