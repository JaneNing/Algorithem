package com.jane_Plus.algorithem.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rex = new ListNode(0);
        ListNode head = rex;
        int key = 0;
        int sum = 0;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            int val;
            sum = n1.val + n2.val + key;
            if (sum >= 10) {
                key = 1;
                val = sum - 10;
            } else {
                key = 0;
                val = sum;
            }
            rex.next = new ListNode(val);
            rex = rex.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n1 == null) {
            if (n2 != null) {
                if (key == 1) {
                    do {
                        int val;
                        sum = n2.val + key;
                        if (sum >= 10) {
                            key = 1;
                            val = sum - 10;
                        } else {
                            key = 0;
                            val = sum;
                        }
                        rex.next = new ListNode(val);
                        rex = rex.next;
                        n2=n2.next;
                    } while (n2 != null);
                    if (key == 1) {
                        rex.next = new ListNode(1);
                    }
                } else {
                    rex.next = n2;
                }
            } else {
                if (key == 1) {
                    rex.next=new ListNode(1);
                }
            }
        } else {
            if (key == 1) {
                do {
                    int val;
                    sum = n1.val + key;
                    if (sum >= 10) {
                        key = 1;
                        val = sum - 10;
                    } else {
                        key = 0;
                        val = sum;
                    }
                    rex.next = new ListNode(val);
                    rex = rex.next;
                    n1=n1.next;
                } while (n1 != null);
                if (key == 1) {
                    rex.next = new ListNode(1);
                }
            } else {
                rex.next = n1;
            }
        }
        return head.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
