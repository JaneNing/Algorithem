package com.jane.algorithem.offer;

public class FiftySix_Second {

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            String s = Integer.toBinaryString(num);
            for (int i = s.length() - 1; i >= 0; i--) {
                arr[31 - (s.length() - 1 - i)] += s.charAt(i) == '1' ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            arr[i] %= 3;
            res = (res * 2 + arr[i]);
        }
        return res;
    }
}
