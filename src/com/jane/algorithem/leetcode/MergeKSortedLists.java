package com.jane.algorithem.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = null;
        ListNode node = null;
        while (!queue.isEmpty()) {
            ListNode node1 = queue.poll();
            if (node1.next != null) {
                queue.add(node1.next);
            }
            if (head == null) {
                head = node = node1;
            } else {
                node.next = node1;
                node = node1;
            }
        }
        return head;
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
