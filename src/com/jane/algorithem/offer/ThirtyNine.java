package com.jane.algorithem.offer;

public class ThirtyNine {

    public int majorityElement(int[] nums) {
        int num = 0, count = 0;
        for (int i : nums) {
            if (count == 0) {
                num = i;
                count++;
            } else {
                if (num == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return num;
    }
}
