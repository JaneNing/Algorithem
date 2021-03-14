package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.List;

public class Sixth {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recursion(ListNode node, List<Integer> list) {
        if (node == null) return;
        recursion(node.next, list);
        list.add(node.val);
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
