package com.jane.algorithem.offer;

public class FortyTwo {

    public int maxSubArray(int[] nums) {
        int ans = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            res = Math.max(res, ans);
            if (ans < 0) {
                ans = 0;
            }
        }
        return res;
    }
}
