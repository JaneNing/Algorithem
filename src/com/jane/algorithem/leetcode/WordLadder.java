package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, List<String>> matchMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = matchMap.computeIfAbsent(s, k -> new ArrayList<>());
                list.add(word);
            }
        }
        Set<String> trace = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        trace.add(beginWord);
        int path = 2;
        while (!deque.isEmpty()) {
            Deque<String> temDeque = new LinkedList<>();
            while (!deque.isEmpty()) {
                String s = deque.pollFirst();
                for (int i = 0; i < s.length(); i++) {
                    String temS = s.subSequence(0, i) + "*" + s.substring(i + 1);
                    List<String> list = matchMap.get(temS);
                    if (list != null) {
                        for (String s1 : list) {
                            if(trace.contains(s1)) continue;
                            if(s1.equals(endWord)) return path;
                            trace.add(s1);
                            temDeque.addLast(s1);
                        }
                    }
                }
            }
            path++;
            deque = temDeque;
        }
        return 0;
    }
}
