package com.jane.algorithem.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode node1, node2, node3, preNode = null;
        if (head == null) return null;
        else if (head.next == null) return head;
        node1 = head;
        node2 = node1.next;
        node3 = node2.next;
        ListNode newHead = head.next;
        while (node2 != null) {
            node2.next = node1;
            node1.next = node3;
            if (preNode == null) {
                preNode = node1;
            } else {
                preNode.next = node2;
                preNode = node1;
            }
            node1 = node3;
            if (node1 != null) {
                node2 = node1.next;
                node3 = node2 == null ? null : node2.next;
            } else {
                node2 = null;
                node3 = null;
            }
        }
        return newHead;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
