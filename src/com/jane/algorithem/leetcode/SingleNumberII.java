package com.jane.algorithem.leetcode;

public class SingleNumberII {

    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        singleNumberII.singleNumber(new int[]{2, 2, 3, 2});
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int tem = 0;
            for (int num : nums) {
                tem += ((num >> i) & 1);
            }
            ans += ((tem % 3) << i);
        }
        return ans;
    }
}
