package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Node> map = new HashMap();
        int len = dislikes.length;
        for (int i = 0; i < len; i++) {
            int first = dislikes[i][0];
            int second = dislikes[i][1];
            Node node1 = map.computeIfAbsent(first, k -> new Node());
            Node node2 = map.computeIfAbsent(second, k -> new Node());
            node1.list.add(node2);
            node2.list.add(node1);
        }
        for (int i = 1; i <= N; i++) {
            Node node = map.get(i);
            if (node == null) continue;
            boolean result = search(node, 0);
            if (!result) return false;
        }
        return true;
    }

    private boolean search(Node node, int path) {
        int flag = path & 1;
        if (node.flag != 0) {
            if (flag + 1 == node.flag || path == 0) {
                return true;
            } else {
                return false;
            }
        }
        node.flag = flag + 1;
        for (int i = 0; i < node.list.size(); i++) {
            Node tarNode = node.list.get(i);
            boolean result = search(tarNode, path + 1);
            if (!result) return false;
        }
        return true;
    }

    private class Node {
        int flag = 0;
        List<Node> list = new ArrayList();
    }
}
