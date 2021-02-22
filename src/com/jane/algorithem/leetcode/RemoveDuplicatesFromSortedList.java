package com.jane.algorithem.leetcode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head, nextNode = head;
        while (nextNode != null) {
            while (nextNode != null && nextNode.val == node.val) {
                nextNode = nextNode.next;
            }
            node.next = nextNode;
            node = nextNode;
        }
        return head;
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
