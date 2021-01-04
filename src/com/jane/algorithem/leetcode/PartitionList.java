package com.jane.algorithem.leetcode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallNode = null, largeNode = null, smallHeadNode = null, largeHeadNode = null;
        while (head != null) {
            if (head.val < x) {
                if (smallNode == null) {
                    smallHeadNode = smallNode = head;
                } else {
                    smallNode.next = head;
                    smallNode = smallNode.next;
                }
                head = head.next;
                smallNode.next = null;
            } else {
                if (largeNode == null) {
                    largeHeadNode = largeNode = head;
                } else {
                    largeNode.next = head;
                    largeNode = largeNode.next;
                }
                head = head.next;
                largeNode.next = null;
            }
        }
        if (smallNode != null) {
            smallNode.next = largeHeadNode;
        }
        return smallHeadNode == null ? largeHeadNode : smallHeadNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
