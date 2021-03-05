package com.jane.algorithem.leetcode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int len1 = 0, len2 = 0;
        ListNode tem1 = headA, tem2 = headB;

        while (tem1 != null) {
            tem1 = tem1.next;
            len1++;
        }

        while (tem2 != null) {
            tem2 = tem2.next;
            len2++;
        }

        tem1 = headA;
        tem2 = headB;

        int offset = len1 - len2;
        while (offset != 0) {
            if (offset > 0) {
                tem1 = tem1.next;
                offset--;
            } else {
                tem2 = tem2.next;
                offset++;
            }
        }

        while (tem1 != tem2) {
            tem1 = tem1.next;
            tem2 = tem2.next;
        }

        return tem1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
