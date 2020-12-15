package com.jane.algorithem.leetcode;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] array = String.valueOf(N).toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (i != 0) {
                if (array[i] < array[i - 1]) {
                    array[i] = '9';
                    array[i - 1]--;
                }
            }
        }
        char max = '0';
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0' && builder.length() == 0) continue;
            max = array[i] > max ? array[i] : max;
            builder.append(max);
        }
        return Integer.valueOf(builder.toString());
    }
}
