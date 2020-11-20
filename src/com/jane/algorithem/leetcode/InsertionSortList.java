package com.jane.algorithem.leetcode;

public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList list = new InsertionSortList();
        ListNode listNode1 = new ListNode((int)(Math.random() * 10000));
        ListNode listNode2 = new ListNode((int)(Math.random() * 10000));
        ListNode listNode3 = new ListNode((int)(Math.random() * 10000));
        ListNode listNode4 = new ListNode((int)(Math.random() * 10000));
        ListNode listNode5 = new ListNode((int)(Math.random() * 10000));
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = list.insertionSortList(listNode1);
        int i = 0;
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
            i++;
        }
    }

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
