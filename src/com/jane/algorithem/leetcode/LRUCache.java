package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    Node head = null, tail = null;
    int count = 0, capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        if (head == node) {
        } else if (tail == node) {
            Node preTail = tail.prev;
            preTail.next = null;
            tail.prev = null;
            tail = preTail;
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node preNode = node.prev;
            preNode.next = node.next;
            node.next.prev = preNode;
            node.prev = null;
            node.next = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        if (head == null) {
            node = new Node(key, value);
            map.put(key, node);
            head = tail = node;
            count++;
        } else if ((node = map.get(key)) == null) {
            if (count < capacity) {
                node = new Node(key, value);
                node.next = head;
                head.prev = node;
                head = node;
                map.put(key, node);
                count++;
            } else {
                if (capacity == 1) {
                    map.remove(tail.key);
                    head = tail = new Node(key, value);
                    map.put(key, head);
                } else {
                    node = new Node(key, value);
                    node.next = head;
                    head.prev = node;
                    head = node;
                    map.remove(tail.key);
                    map.put(key, node);
                    Node preTail = tail.prev;
                    preTail.next = null;
                    tail.prev = null;
                    tail = preTail;
                }
            }
        } else {
            node.val = value;
            if (head == node) {
            } else if (tail == node) {
                Node preTail = tail.prev;
                preTail.next = null;
                tail.prev = null;
                tail = preTail;
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                Node preNode = node.prev;
                preNode.next = node.next;
                node.next.prev = preNode;
                node.prev = null;
                node.next = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
    }

    private class Node {
        Node prev, next;
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
