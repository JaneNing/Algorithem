package com.jane.algorithem.leetcode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len <= 1) return true;
        int path = (len - 1) >>> 1;
        ListNode preNode = null, nextNode = head.next;
        node = head;
        while (path != 0) {
            node.next = preNode;
            preNode = node;
            node = nextNode;
            nextNode = nextNode.next;
            path--;
        }
        node.next = preNode;
        if ((len & 1) == 1) {
            node = node.next;
        }
        while (node != null) {
            if (node.val != nextNode.val) return false;
            node = node.next;
            nextNode = nextNode.next;
        }
        return true;
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
