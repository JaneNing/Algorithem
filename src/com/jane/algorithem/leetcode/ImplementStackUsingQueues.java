package com.jane.algorithem.leetcode;

import java.util.LinkedList;

public class ImplementStackUsingQueues {

    LinkedList<Integer> list1 = new LinkedList();

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = list1.size();
        list1.addLast(x);
        while (size-- != 0) {
            list1.addLast(list1.pollFirst());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return list1.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list1.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list1.isEmpty();
    }
}
