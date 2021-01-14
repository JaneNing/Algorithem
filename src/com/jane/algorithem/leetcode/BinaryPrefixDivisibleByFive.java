package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleByFive {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int[] arr = new int[A.length];
        arr[0] = A[0];
        for (int i = 0; i < A.length; i++) {
            if (i != 0) {
                arr[i] = (arr[i - 1] * 2 + A[i]) % 5;
            }
            res.add(arr[i] == 0);
        }
        return res;
    }
}
