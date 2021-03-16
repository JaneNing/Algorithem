package com.jane.algorithem.offer;

public class Eighteen {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode preNode = null, node = head, nextNode = head.next;
        while (nextNode != null || node.val == val) {
            if (node.val == val) {
                if (preNode == null) {
                    preNode = nextNode;
                } else {
                    preNode.next = nextNode;
                }
                break;
            } else {
                nextNode = nextNode.next;
                preNode = preNode == null ? node : preNode.next;
                node = node.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
