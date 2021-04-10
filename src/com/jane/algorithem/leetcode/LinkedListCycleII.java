package com.jane.algorithem.leetcode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head, quickNode = head, indexNode = head;
        if (head == null) return null;
        while (true) {
            quickNode = quickNode.next;
            if (quickNode == null) return null;
            quickNode = quickNode.next;
            if (quickNode == null) return null;
            slowNode = slowNode.next;
            if (slowNode == null) return null;
            if (quickNode == slowNode) break;
        }
        while (indexNode != slowNode) {
            slowNode = slowNode.next;
            indexNode = indexNode.next;
        }
        return indexNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
