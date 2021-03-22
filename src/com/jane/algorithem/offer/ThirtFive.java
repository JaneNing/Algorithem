package com.jane.algorithem.offer;

public class ThirtFive {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node1 = head, node2;
        while (node1 != null) {
            node2 = node1.next;
            node1.next = new Node(node1.val);
            node1.next.next = node2;
            node1 = node2;
        }

        node1 = node2 = head;
        while (node1 != null) {
            node1.next.random = node1.random == null ? null : node1.random.next;
            node1 = node1.next.next;
        }

        node1 = head;
        node2 = head.next;
        Node newHead = node2;
        while (node1 != null) {
            node1.next = node1.next.next;
            node1 = node2.next;
            node2.next = node2.next == null ? null : node2.next.next;
            node2 = node1 == null ? null : node1.next;
        }
        return newHead;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
