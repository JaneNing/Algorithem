package com.jane.algorithem.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int l = 0 ,r = 0 , res = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(set.contains(c)){
                set.remove(s.charAt(l++));
            }else{
                set.add(c);
                r++;
                res = Math.max(res,r-l);
            }
        }
        return res;
    }

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> set = new HashSet();
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (set.contains(i)) continue;
            res++;
            fun(isConnected, i, set);
        }
        return res;
    }

    private void fun(int[][] isConnected, int i, Set<Integer> set) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !set.contains(j)) {
                set.add(j);
                fun(isConnected, j, set);
            }
        }
    }
}
