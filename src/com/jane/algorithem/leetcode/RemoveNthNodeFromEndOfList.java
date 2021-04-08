package com.jane.algorithem.leetcode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, indexNode = head;
        ListNode preNode = null;
        while (n-- != 0) {
            indexNode = indexNode.next;
        }
        while (indexNode != null) {
            preNode = node;
            node = node.next;
            indexNode = indexNode.next;
        }
        if (preNode == null) {
            return head.next;
        } else {
            preNode.next = node.next;
            node.next = null;
            return head;
        }
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
