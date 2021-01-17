package com.jane.algorithem.leetcode;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = 1;
        }
        int index = 2;
        while (index <= n) {
            int[] newArr = new int[5];
            for (int i = 0; i < 5; i++) {
                for (int j = i; j < 5; j++) {
                    newArr[j] += arr[i];
                }
            }
            arr = newArr;
            index++;
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += arr[i];
        }
        return res;
    }
}
