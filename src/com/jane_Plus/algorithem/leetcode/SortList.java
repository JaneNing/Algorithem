package com.jane_Plus.algorithem.leetcode;


import java.util.Arrays;

public class SortList {
    public ListNode sortList_148(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = head, p2 = head;
        while (p2 != tail) {
            p2 = p2.next;
            mid = mid.next;
            if (p2 != tail) {
                p2 = p2.next;
            }
        }
        ListNode mergeNode1 = sort(head, mid);
        ListNode mergeNode2 = sort(mid, tail);
        return merge(mergeNode1, mergeNode2);
    }

    private ListNode merge(ListNode mergeNode1, ListNode mergeNode2) {
        ListNode merge = new ListNode(0), p1 = mergeNode1, p2 = mergeNode2;
        ListNode p3 = merge;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3=p3.next;
        }
        if (p1 == null) {
            p3.next = p2;
        }else {
            p3.next = p1;
        }
        return merge.next;
    }


    static class ListNode {
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
