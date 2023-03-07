package com.jane.algorithem.leetcode;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClosestRoom {

    //value-index
    TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {
        String[] arr1 = o1.split("-");
        String[] arr2 = o2.split("-");
        int res = arr1[0].compareTo(arr2[0]);
        if (res == 0) {
            res = arr1[1].compareTo(arr2[1]);
        }
        return res;
    });

    public static void main(String[] args) {
        ClosestRoom closestRoom = new ClosestRoom();
        closestRoom.closestRoom(new int[][]{{2, 2}, {1, 2}, {3, 2}}, new int[][]{{3, 1}, {3, 3}, {5, 2}});
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        for (int[] room : rooms) {
            String s = room[1] + "-" + room[0];
            treeSet.add(s);
        }
        int[] res = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            String key = query[1] + "-" + query[0];
            SortedSet<String> set1 = treeSet.headSet(key);
            if (set1.size() == 0) {
                SortedSet<String> set2 = treeSet.tailSet(key);
                String first = set2.first();
                res[index++] = Integer.parseInt(first.split("-")[1]);
            } else {
                String last = set1.last();
                SortedSet<String> set2 = treeSet.tailSet(key);
                String first = set2.first();
                if (!last.split("-")[0].equals(String.valueOf(query[1]))) {
                    res[index++] = Integer.parseInt(first.split("-")[1]);
                } else {
                    int index1 = Integer.parseInt(last.split("-")[1]);
                    int index2 = Integer.parseInt(first.split("-")[1]);
                    if (Math.abs(index1 - query[1]) <= Math.abs(index2 - query[1])) {
                        res[index++] = index1;
                    } else {
                        res[index++] = index2;
                    }
                }
            }
        }
        return res;
    }
}
