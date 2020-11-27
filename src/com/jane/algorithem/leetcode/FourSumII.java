package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int num = map1.getOrDefault(A[i] + B[j], 0);
                map1.put(A[i] + B[j], num + 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int num = map2.getOrDefault(C[i] + D[j], 0);
                map2.put(C[i] + D[j], num + 1);
            }
        }
        AtomicInteger res = new AtomicInteger();
        map1.forEach((key1, value1) -> {
            Integer num = map2.getOrDefault(-key1, 0);
            res.addAndGet(num * value1);
        });
        return res.get();
    }
}
