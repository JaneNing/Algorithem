package com.jane.algorithem.leetcode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode temNode = head;
        ListNode newHead = new ListNode(100000 + 1);
        while (temNode != null) {
            len++;
            if (newHead.val > temNode.val) {
                newHead = temNode;
            }
            temNode = temNode.next;
        }
        int path = 2;
        ListNode temHead = head;
        while (path <= len * 2) {
            ListNode temHeadNode = temHead, lastNode = null;
            temHead = null;
            tag:
            while (temHeadNode != null) {
                ListNode node1 = temHeadNode, node2 = temHeadNode;
                int basePath = path >>> 1;
                while (basePath-- != 0) {
                    node2 = node2.next;
                    if (node2 == null) break tag;
                }
                ListNode indexNode = null;
                int count1 = path >>> 1, count2 = path >>> 1;
                while (count1 != 0 && count2 != 0 && node2 != null) {
                    if (node1.val <= node2.val) {
                        if (temHead == null) {
                            temHead = node1;
                        }
                        if (indexNode == null) {
                            indexNode = node1;
                            if (lastNode != null) {
                                lastNode.next = indexNode;
                            }
                        } else {
                            indexNode.next = node1;
                            indexNode = indexNode.next;
                        }
                        count1--;
                        node1 = node1.next;
                    } else {
                        if (temHead == null) {
                            temHead = node2;
                        }
                        if (indexNode == null) {
                            indexNode = node2;
                            if (lastNode != null) {
                                lastNode.next = indexNode;
                            }
                        } else {
                            indexNode.next = node2;
                            indexNode = indexNode.next;
                        }
                        count2--;
                        node2 = node2.next;
                    }
                }
                while (count1 != 0) {
                    indexNode.next = node1;
                    indexNode = indexNode.next;
                    node1 = node1.next;
                    count1--;
                }
                while (count2 != 0 && node2 != null) {
                    indexNode.next = node2;
                    indexNode = indexNode.next;
                    node2 = node2.next;
                    count2--;
                }
                lastNode = indexNode;
                indexNode.next = node2;
                temHeadNode = node2;
            }
            path = path << 1;
        }
        return newHead;
    }

//    public ListNode sortList(ListNode head) {
//        int path = 2, len = 0;
//        ListNode node = head;
//        while (node != null) {
//            len++;
//            node = node.next;
//        }
//        ListNode newHead = head;
//        while (path < len * 2) {
//            ListNode base = newHead, node1, node2, lastNode = null;
//            newHead = null;
//            tag:
//            while (base != null) {
//                node2 = node1 = base;
//                node = null;
//                int count = path / 2;
//                while (count != 0) {
//                    node2 = node2.next;
//                    if (node2 == null) {
//                        break tag;
//                    }
//                    count--;
//                }
//                int count1 = path / 2, count2 = path / 2;
//                while (count1 != 0 && count2 != 0 && node2 != null) {
//                    if (node1.val <= node2.val) {
//                        if (newHead == null) {
//                            newHead = node1;
//                        }
//                        if (node == null) {
//                            if (lastNode != null) {
//                                lastNode.next = node1;
//                            }
//                            node = node1;
//                        } else {
//                            node.next = node1;
//                            node = node.next;
//                        }
//                        count1--;
//                        node1 = node1.next;
//                    } else {
//                        if (newHead == null) {
//                            newHead = node2;
//                        }
//                        if (node == null) {
//                            if (lastNode != null) {
//                                lastNode.next = node2;
//                            }
//                            node = node2;
//                        } else {
//                            node.next = node2;
//                            node = node.next;
//                        }
//                        count2--;
//                        node2 = node2.next;
//                    }
//                }
//                while (count1 != 0) {
//                    node.next = node1;
//                    node1 = node1.next;
//                    node = node.next;
//                    count1--;
//                }
//                while (count2 != 0 && node2 != null) {
//                    node.next = node2;
//                    node2 = node2.next;
//                    node = node.next;
//                    count2--;
//                }
//                base = node2;
//                node.next = base;
//                lastNode = node;
//            }
//            path *= 2;
//        }
//        return newHead;
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