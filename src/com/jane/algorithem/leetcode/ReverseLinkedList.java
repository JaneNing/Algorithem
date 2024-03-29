package com.jane.algorithem.leetcode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode[] list = new ListNode[1];
        recursion(null, head, list);
        return list[0];
    }

    private void recursion(ListNode preNode, ListNode node, ListNode[] list) {
        if (node == null) {
            list[0] = preNode;
            return;
        }
        recursion(node, node.next, list);
        node.next = preNode;
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        reverse(null, head, newHead);
//        return newHead;
//    }
//
//    private void reverse(ListNode pre, ListNode node, ListNode newHead) {
//        if (node == null) {
//            newHead = pre;
//            return;
//        }
//        reverse(node, node.next, newHead);
//        node.next = pre;
//    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode pre, node, next;
//        pre = null;
//        node = head;
//        next = head.next;
//        while (node != null) {
//            node.next = pre;
//            pre = node;
//            node = next;
//            if (next != null) {
//                next = next.next;
//            }
//        }
//        return pre;
//    }

    private static class ListNode {
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
