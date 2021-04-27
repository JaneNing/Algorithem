package com.jane.algorithem.leetcode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (count != k && node != null) {
            count++;
            node = node.next;
        }
        if (count == k) {
            ListNode nextNode = reverseKGroup(node, k);
            node = head;
            ListNode temNode;
            while (k-- != 0) {
                temNode = node.next;
                node.next = nextNode;
                nextNode = node;
                node = temNode;
            }
            return nextNode;
        } else {
            return head;
        }
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        int count = 0;
//        ListNode node = head;
//        while (node != null && count != k) {
//            node = node.next;
//            count++;
//        }
//        if (count == k) {
//            ListNode nextHead = reverseKGroup(node, k);
//            node = head;
//            ListNode preNode = nextHead, nextNode = node.next;
//            while (k != 0) {
//                node.next = preNode;
//                preNode = node;
//                node = nextNode;
//                if (nextNode != null) {
//                    nextNode = nextNode.next;
//                }
//                k--;
//            }
//            return preNode;
//        } else {
//            return head;
//        }
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
