package com.jane.algorithem.leetcode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head, node = head.next, preNode = head, tem, preTem;
        while (node != null) {
            preTem = null;
            tem = newHead;
            while (tem.val <= node.val && tem != node) {
                preTem = tem;
                tem = tem.next;
            }
            if (tem == node) {
                preNode = node;
                node = node.next;
            } else {
                preNode.next = node.next;
                if (preTem == null) {
                    node.next = newHead;
                    newHead = node;
                } else {
                    preTem.next = node;
                    node.next = tem;
                }
                node = preNode.next;
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
