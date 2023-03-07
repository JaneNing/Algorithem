package com.jane.algorithem.offer;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FortyOne {

    private PriorityQueue<Integer> bigQueue;
    private PriorityQueue<Integer> smallQueue;

    public FortyOne() {
        bigQueue = new PriorityQueue<>();
        smallQueue = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (smallQueue.size() != bigQueue.size()) {
            bigQueue.add(num);
            smallQueue.add(bigQueue.poll());
        } else {
            smallQueue.add(num);
            bigQueue.add(smallQueue.poll());
        }
    }

    public double findMedian() {
        if (smallQueue.size() != bigQueue.size()) {
            return bigQueue.peek();
        } else {
            return (bigQueue.peek() + smallQueue.peek()) * 1.0 / 2;
        }
    }
}
