package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortItemsByGroupsRespectingDependencies {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, ItemNode> itemMap = new HashMap<>();
        Map<Integer, GroupNode> groupMap = new HashMap<>();
        Map<Integer, List<Integer>> groupItemMap = new HashMap<>();
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        int len = group.length, groupId = m;
        Set<ItemNode> itemSet = new HashSet<>();
        Set<GroupNode> groupSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            ItemNode itemNode = new ItemNode();
            itemNode.itemId = i;
            itemMap.put(i, itemNode);

            if (group[i] == -1) {
                group[i] = groupId++;
            }
            GroupNode groupNode = groupMap.get(group[i]);
            if (groupNode == null) {
                groupNode = new GroupNode();
                groupNode.groupId = group[i];
                groupMap.put(group[i], groupNode);
            }
            itemSet.add(itemNode);
            groupSet.add(groupNode);
            List<Integer> list = groupItemMap.computeIfAbsent(group[i], k -> new ArrayList<>());
            list.add(i);
        }
        for (int i = 0; i < len; i++) {
            List<Integer> list = beforeItems.get(i);
            if (list.isEmpty()) continue;
            ItemNode itemNode = itemMap.get(i);
            GroupNode groupNode = groupMap.get(group[i]);
            itemSet.remove(itemNode);
            for (Integer integer : list) {
                if (group[integer] != groupNode.groupId) {
                    groupSet.remove(groupNode);
                }
                itemNode.preSet.add(integer);
                itemNode.count++;
                itemMap.get(integer).nextSet.add(i);

                if (group[integer] != groupNode.groupId) {
                    groupNode.preSet.add(group[integer]);
                    groupNode.count = groupNode.preSet.size();
                    groupMap.get(group[integer]).nextSet.add(group[i]);
                }
            }
        }
        if (groupSet.isEmpty()) return new int[0];
        Set<Integer> set = new HashSet<>();
        for (GroupNode groupNode : groupSet) {
            findGroup(set, groupNode, groupMap);
        }
        if (set.size() != groupMap.size()) return new int[0];
        set.clear();
        for (ItemNode itemNode : itemSet) {
            findItem(set, itemNode, itemMap);
        }
        if (set.size() != n) return new int[0];
        while (!groupSet.isEmpty()) {
            Set<GroupNode> temSet = new HashSet<>();
            Iterator<GroupNode> iterator = groupSet.iterator();
            while (iterator.hasNext()) {
                GroupNode groupNode = iterator.next();
                List<Integer> list = groupItemMap.get(groupNode.groupId);
                for (Integer integer : list) {
                    fun(res, group, itemMap, itemMap.get(integer), groupNode.groupId);
                }
                for (Integer integer : groupNode.nextSet) {
                    GroupNode nextNode = groupMap.get(integer);
                    nextNode.preSet.remove(groupNode.groupId);
                    if (nextNode.preSet.isEmpty()) {
                        temSet.add(nextNode);
                    }
                }
                iterator.remove();
            }
            groupSet = temSet;
        }
        Iterator<Integer> iterator = res.iterator();
        int[] ans = new int[n];
        int index = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            ans[index++] = next;
        }
        return ans;
    }

    private void fun(LinkedHashSet<Integer> res, int[] group, Map<Integer, ItemNode> itemMap, ItemNode itemNode, int groupId) {
        if (res.contains(itemNode.itemId)) return;
        if (group[itemNode.itemId] != groupId) return;
        if (itemNode.preSet.isEmpty()) {
            res.add(itemNode.itemId);
            return;
        }
        Iterator<Integer> iterator = itemNode.preSet.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            fun(res, group, itemMap, itemMap.get(next), groupId);
        }
        res.add(itemNode.itemId);
    }

    private void findItem(Set<Integer> set, ItemNode itemNode, Map<Integer, ItemNode> itemMap) {
        if (itemNode.count == 0) {
            set.add(itemNode.itemId);
            for (Integer integer : itemNode.nextSet) {
                ItemNode node = itemMap.get(integer);
                node.count--;
                findItem(set, node, itemMap);
            }
        }
    }

    private void findGroup(Set<Integer> set, GroupNode groupNode, Map<Integer, GroupNode> groupMap) {
        if (groupNode.count == 0) {
            set.add(groupNode.groupId);
            for (Integer integer : groupNode.nextSet) {
                GroupNode node = groupMap.get(integer);
                node.count--;
                findGroup(set, node, groupMap);
            }
        }
    }

    private class ItemNode {
        int itemId, count;
        Set<Integer> preSet = new HashSet<>();
        Set<Integer> nextSet = new HashSet<>();
    }

    private class GroupNode {
        int groupId, count;
        Set<Integer> preSet = new HashSet<>();
        Set<Integer> nextSet = new HashSet<>();
    }
}
