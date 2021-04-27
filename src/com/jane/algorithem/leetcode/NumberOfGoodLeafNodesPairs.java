package com.jane.algorithem.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class NumberOfGoodLeafNodesPairs {

    public int countPairs(TreeNode root, int distance) {
        int[] res = new int[1];
        recursion(root, res, distance);
        return res[0];
    }

    private TreeMap<Integer, Integer> recursion(TreeNode node, int[] res, int distance) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(1, 1);
            return map;
        }
        TreeMap<Integer, Integer> leftMap = recursion(node.left, res, distance);
        TreeMap<Integer, Integer> rightMap = recursion(node.right, res, distance);
        if (leftMap == null) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = rightMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                map.put(entry.getKey() + 1, entry.getValue());
            }
            return map;
        }
        if (rightMap == null) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = leftMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                map.put(entry.getKey() + 1, entry.getValue());
            }
            return map;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = leftMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            SortedMap<Integer, Integer> headMap = rightMap.headMap(distance - entry.getKey() + 1);
            Iterator<Integer> iterator1 = headMap.values().iterator();
            while (iterator1.hasNext()) {
                Integer next = iterator1.next();
                res[0] += next * entry.getValue();
                if (node.val == 15) {
                    Iterator<Map.Entry<Integer, Integer>> iterator3 = leftMap.entrySet().iterator();
                    System.out.println("leftBranch");
                    while (iterator3.hasNext()) {
                        Map.Entry<Integer, Integer> entry3 = iterator3.next();
                        System.out.println(entry3.getKey() + " " + entry3.getValue());
                    }
                    System.out.println("end left");
                    iterator3 = rightMap.entrySet().iterator();
                    System.out.println("rightBranch");
                    while (iterator3.hasNext()) {
                        Map.Entry<Integer, Integer> entry3 = iterator3.next();
                        System.out.println(entry3.getKey() + " " + entry3.getValue());
                    }
                    System.out.println("end right");
                }
                System.out.println(node.val + " " + res[0]);
            }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        iterator = leftMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            map.put(entry.getKey() + 1, entry.getValue());
        }
        iterator = rightMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            map.put(entry.getKey() + 1, map.getOrDefault(entry.getKey() + 1, 0) + entry.getValue());
        }
        if (node.val == 98) {

        }
        return map;
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
