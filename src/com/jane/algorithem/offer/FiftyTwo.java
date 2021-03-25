package com.jane.algorithem.offer;

public class FiftyTwo {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int count1 = 0, count2 = 0;
        ListNode node1 = headA, node2 = headB;
        while (node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null) {
            node1 = node1.next;
            count1++;
        }

        while (node2 != null) {
            node2 = node2.next;
            count2++;
        }
        node1 = headA;
        node2 = headB;
        while (count1 != 0) {
            node1 = node1.next;
            count1--;
        }
        while (count2 != 0) {
            node2 = node2.next;
            count2--;
        }
        while (node1 != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
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
