package com.jane.algorithem.offer;

import java.util.List;

public class TwentyTwo {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head , slowNode = head;
        while (k-- != 0){
            if(fastNode == null){
                return null;
            }
            fastNode = fastNode.next;
        }
        while (fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
