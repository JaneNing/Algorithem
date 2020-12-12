package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer,Integer> nodeVal = new LinkedHashMap<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        Queue<TreeNode> valQueue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        indexQueue.add(1);
        valQueue.add(root);
        while (!indexQueue.isEmpty()) {
            Integer index = indexQueue.poll();
            TreeNode node = valQueue.poll();
            map.put(node.val, node);
            nodeVal.put(index,node.val);
            if (node.left != null) {
                indexQueue.add(index * 2);
                valQueue.add(node.left);
            }
            if (node.right != null) {
                indexQueue.add(index * 2 + 1);
                valQueue.add(node.right);
            }
        }
        Set<Integer> queue = new HashSet<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = nodeVal.entrySet().iterator();
        int i = 2;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(entry.getKey() >= i){
                queue.clear();
                i *= 2;
            }
            queue.add(entry.getKey());
        }
        while (queue.size() != 1) {
            Set<Integer> set = new HashSet<>();
            for (Integer integer : queue) {
                set.add(integer / 2);
            }
            queue = set;
        }
        int val = nodeVal.get(queue.iterator().next());
        return map.get(val);
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
