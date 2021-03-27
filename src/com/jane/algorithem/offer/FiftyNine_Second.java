package com.jane.algorithem.offer;

import java.util.Deque;
import java.util.LinkedList;

public class FiftyNine_Second {

    Deque<Integer> maxDeque;
    Deque<Integer> numDeque;

    public FiftyNine_Second() {
        maxDeque = new LinkedList<>();
        numDeque = new LinkedList<>();
    }

    public int max_value() {
        if (maxDeque.size() == 0) return -1;
        return maxDeque.peekFirst();
    }

    public void push_back(int value) {
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(value);
        numDeque.addLast(value);
    }

    public int pop_front() {
        if (numDeque.size() == 0) return -1;
        if (numDeque.peekFirst().equals(maxDeque.peekFirst())) {
            maxDeque.pollFirst();
        }
        return numDeque.pollFirst();
    }
}
