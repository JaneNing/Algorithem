package com.jane.algorithem.offer;

public class TwentyFour {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = null, node = head, nextNode = head.next;
        while (node != null) {
            node.next = preNode;
            preNode = node;
            node = nextNode;
            nextNode = nextNode == null ? null : nextNode.next;
        }
        return preNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
