package com.jane.algorithem.leetcode;

public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        int i = 1;
        ListNode node1 = head;
        while (i != k) {
            node1 = node1.next;
            i++;
        }
        ListNode node2 = head, node3 = head;
        i = 0;
        while (i != k) {
            node3 = node3.next;
            i++;
        }
        while (node3 != null) {
            node2 = node2.next;
            node3 = node3.next;
        }
        int tem = node1.val;
        node1.val = node2.val;
        node2.val = tem;
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
