package com.jane.algorithem.offer;

public class Eleven {

    public int minArray(int[] numbers) {
        return search(numbers, 0, numbers.length - 1);
    }

    private int search(int[] numbers, int l, int r) {
        if (l > r) return Integer.MAX_VALUE;
        if (l == r) return numbers[l];
        int m = l + (r - l) / 2;
        if (m >= numbers.length) return Integer.MAX_VALUE;
        int num = numbers[m];
        if (num > numbers[numbers.length - 1]) {
            if (m + 1 < numbers.length) {
                return Math.min(num, search(numbers, m + 1, r));
            }
        } else if (num < numbers[numbers.length - 1]) {
            if (m - 1 >= 0) {
                return Math.min(num, search(numbers, l, m - 1));
            }
        } else {
            if (m - 1 < 0) {
                return Math.min(num, search(numbers, m + 1, r));
            } else if (m + 1 >= numbers.length) {
                return Math.min(num, search(numbers, l, m - 1));
            } else {
                return Math.min(num, Math.min(search(numbers, l, m - 1),
                        search(numbers, m + 1, r)));
            }
        }
        return num;
    }
}
