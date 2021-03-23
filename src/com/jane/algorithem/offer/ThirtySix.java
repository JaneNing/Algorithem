package com.jane.algorithem.offer;

public class ThirtySix {

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node[] nodes = recursion(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];
        return nodes[0];
    }

    private Node[] recursion(Node node) {
        if (node == null) return new Node[2];
        Node[] leftList = recursion(node.left);
        Node[] rightList = recursion(node.right);
        Node preNode = leftList[1];
        Node nextNode = rightList[0];
        if (preNode != null) {
            preNode.right = node;
            node.left = preNode;
        }
        if (nextNode != null) {
            nextNode.left = node;
            node.right = nextNode;
        }
        Node[] nodes = new Node[2];
        nodes[0] = leftList[0] == null ? node : leftList[0];
        nodes[1] = rightList[1] == null ? node : rightList[1];
        return nodes;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
