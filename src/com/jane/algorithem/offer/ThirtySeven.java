package com.jane.algorithem.offer;

import java.util.LinkedList;

public class ThirtySeven {

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            if (treeNode == null) {
                if (builder.length() != 0) {
                    builder.append(" ");
                }
                builder.append("null");
            } else {
                if (builder.length() != 0) {
                    builder.append(" ");
                }
                builder.append(treeNode.val);
                queue.addLast(treeNode.left);
                queue.addLast(treeNode.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            queue.add(s[i].equals("null") ? null : new TreeNode(Integer.parseInt(s[i])));
        }
        TreeNode root = null, node;
        LinkedList<TreeNode> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            if (root == null) {
                node = root = treeNode;
                list.add(node);
            } else {
                node = list.pollFirst();
                node.left = treeNode;
                if(node.left != null){
                    list.add(node.left);
                }
                node.right = queue.pollFirst();
                if(node.right != null){
                    list.add(node.right);
                }
            }
        }
        return root;
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
