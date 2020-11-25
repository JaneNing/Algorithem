package com.jane.algorithem.leetcode;

public class IncreasingDecresingString {

    public static void main(String[] args) {
        IncreasingDecresingString increasingDecresingString = new IncreasingDecresingString();
        System.out.println(increasingDecresingString.sortString("abc"));
    }

    public String sortString(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Node head = null, node = null, preNode;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (head == null) {
                    node = head = new Node((char) ('a' + i), arr[i]);
                } else {
                    node.next = new Node((char) ('a' + i), arr[i]);
                    preNode = node;
                    node = node.next;
                    node.pre = preNode;
                }
            }
        }
        Node tail = node, temNode;
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            node = head;
            while (node != null) {
                builder.append(node.c);
                if (--node.num == 0) {
                    if (node.pre == null) {
                        head = node.next;
                        if (head != null) {
                            head.pre = null;
                        } else {
                            tail = null;
                        }
                    } else if (node.next == null) {
                        tail = node.pre;
                        tail.next = null;
                    } else {
                        temNode = node.pre;
                        node.pre.next = node.next;
                        node.next.pre = temNode;
                    }
                }
                node = node.next;
            }
            node = tail;
            while (node != null) {
                builder.append(node.c);
                if (--node.num == 0) {
                    if (node.pre == null) {
                        head = node.next;
                        if (head != null) {
                            head.pre = null;
                        } else {
                            tail = null;
                        }
                    } else if (node.next == null) {
                        tail = node.pre;
                        tail.next = null;
                    } else {
                        temNode = node.pre;
                        node.pre.next = node.next;
                        node.next.pre = temNode;
                    }
                }
                node = node.pre;
            }
        }
        return builder.toString();
    }

    private class Node {
        char c;
        int num;
        Node pre, next;

        public Node(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }

}
