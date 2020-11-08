package com.jane.algorithem.leetcode;

/**
 * 10/31/2020
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode node = head;
        int status = head.val / 10;
        int num;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null || status != 0) {
            num = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + status;
            node.next = new ListNode(num % 10);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            status = num / 10;
        }
        return head;
    }

    public class ListNode {
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
