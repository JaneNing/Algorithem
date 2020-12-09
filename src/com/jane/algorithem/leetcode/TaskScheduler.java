package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[27];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i] - 'A']++;
        }
        Arrays.sort(arr);
        int res = 0;
        while (arr[26] != 0) {
            for (int i = 0; i < n + 1; i++) {
                if (arr[26 - i] != 0) {
                    arr[26 - i]--;
                    res++;
                } else {
                    if (arr[26] != 0) {
                        res += (n - i + 1);
                    }
                    break;
                }
            }
            Arrays.sort(arr);
        }
        return res;
    }
}