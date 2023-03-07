package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SeatReservationManager {

//    TreeMap<Integer, Node> map;
//    Node headNode;

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public SeatReservationManager(int n) {
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
//        map = new TreeMap<>();
//        for (int i = 1; i <= n; i++) {
//            Node node = new Node();
////            Node preNode = map.get(i - 1);
////            node.prev = preNode;
////            if (preNode != null) {
////                preNode.next = node;
////            }
//            map.put(i, node);
////            if (i == 1) {
////                headNode = node;
////            }
//        }
    }

    public int reserve() {
//        Node temNode = headNode;
//        headNode = headNode.next;
//        map.
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }

    private class Node {
        //        Node prev, next;
        int val;
    }
}
