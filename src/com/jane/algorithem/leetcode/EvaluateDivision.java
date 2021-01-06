package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            Node node1 = nodeMap.computeIfAbsent(list.get(0), k -> new Node());
            node1.map.put(list.get(1), values[i]);
            Node node2 = nodeMap.computeIfAbsent(list.get(1), k -> new Node());
            node2.map.put(list.get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            Node node = nodeMap.get(list.get(0));
            if (node == null || !nodeMap.containsKey(list.get(1))) {
                res[i] = -1;
                continue;
            }
            Set<String> set = new HashSet<>();
            set.add(list.get(0));
            res[i] = fun(set, node, list.get(1), 1, nodeMap);
        }
        return res;
    }

    private double fun(Set<String> set, Node node, String target, double res, Map<String, Node> nodeMap) {
        Double targetRes = node.map.get(target);
        if (targetRes != null) {
            return res * targetRes;
        }
        Iterator<Map.Entry<String, Double>> iterator = node.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            String key = entry.getKey();
            if (set.contains(key)) continue;
            set.add(key);
            double temRes = fun(set, nodeMap.get(key), target, res * entry.getValue(), nodeMap);
            if (temRes != -1) return temRes;
            set.remove(key);
        }
        return -1;
    }

    private class Node {
        Map<String, Double> map = new HashMap<>();
    }
}
