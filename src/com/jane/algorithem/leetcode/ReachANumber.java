package com.jane.algorithem.leetcode;

public class ReachANumber {

    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int i = 1, sum = 0, count = 0;
        while (!(sum <= target && sum + i > target)) {
            sum += (i++);
            count++;
        }
        if (sum == target) return count;
        if ((sum + i - target) % 2 == 0) return count + 1;
        return i % 2 == 0 ? count + 2 : count + 3;
    }
}
