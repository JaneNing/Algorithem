package com.jane.algorithem.offer;

public class TwentyFive {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode nextNode, newHead = l1.val < l2.val ? l1 : l2;
        boolean priority = true;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (l1.next == null) {
                    l1.next = l2;
                    l1 = null;
                } else {
                    if (l1.next.val < l2.val) {
                        l1 = l1.next;
                        priority = false;
                    } else {
                        nextNode = l1.next;
                        l1.next = l2;
                        l1 = nextNode;
                        priority = true;
                    }
                }
            } else if (l2.val < l1.val) {
                if (l2.next == null) {
                    l2.next = l1;
                    l2 = null;
                } else {
                    if (l2.next.val < l1.val) {
                        l2 = l2.next;
                        priority = true;
                    } else {
                        nextNode = l2.next;
                        l2.next = l1;
                        l2 = nextNode;
                        priority = false;
                    }
                }
            } else {
                if (!priority) {
                    nextNode = l1.next;
                    l1.next = l2;
                    l1 = nextNode;
                } else {
                    nextNode = l2.next;
                    l2.next = l1;
                    l2 = nextNode;
                }
                priority = !priority;
            }
        }
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
