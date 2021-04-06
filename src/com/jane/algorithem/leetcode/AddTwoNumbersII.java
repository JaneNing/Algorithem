package com.jane.algorithem.leetcode;

import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode nextNode = null, node;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int i1 = stack1.isEmpty() ? 0 : stack1.pop();
            int i2 = stack2.isEmpty() ? 0 : stack2.pop();
            node = new ListNode((i1 + i2 + flag) % 10);
            flag = (i1 + i2 + flag) / 10;
            node.next = nextNode;
            nextNode = node;
            node = null;
        }
        if (flag == 1) {
            node = new ListNode(1);
            node.next = nextNode;
            nextNode = node;
            node = null;
        }
        return nextNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
