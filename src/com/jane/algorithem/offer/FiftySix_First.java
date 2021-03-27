package com.jane.algorithem.offer;

public class FiftySix_First {

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        String s = Integer.toBinaryString(res);
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                num = (int) Math.pow(2, s.length() - 1 - i);
                break;
            }
        }
        int num1 = 0;
        int num2 = 0;
        for (int i : nums) {
            if ((i & num) == num) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};
    }
}
