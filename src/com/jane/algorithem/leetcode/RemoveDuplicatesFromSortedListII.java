package com.jane.algorithem.leetcode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode preNode = null, node = head, nextNode = head.next, newHead = null;
        int num = 1;
        while (node != null) {
            while (nextNode != null && nextNode.val == node.val) {
                nextNode = nextNode.next;
                num++;
            }
            if (num == 1) {
                if (newHead == null) {
                    newHead = node;
                }
                preNode = node;
                node = nextNode;
                nextNode = nextNode != null ? nextNode.next : null;
            } else {
                if (preNode != null) {
                    preNode.next = nextNode;
                }
                node = nextNode;
                nextNode = nextNode != null ? nextNode.next : null;
                num = 1;
            }
        }
        return newHead;
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
