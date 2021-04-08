package com.jane.algorithem.leetcode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode node = head;
        ListNode node1 = head == l1 ? l1.next : l1;
        ListNode node2 = head == l2 ? l2.next : l2;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                node.next = node2;
                node2 = node2.next;
            } else if (node2 == null) {
                node.next = node1;
                node1 = node1.next;
            } else {
                if (node1.val < node2.val) {
                    node.next = node1;
                    node1 = node1.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                }
            }
            node = node.next;
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
