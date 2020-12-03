package com.jane.algorithem.leetcode;

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = Math.max(0, k - nums2.length), end = Math.min(nums1.length, k);
        int[] res = new int[k];
        for (int i = start; i <= end; i++) {
            int[] sequence1 = getSequence(nums1, i);
            int[] sequence2 = getSequence(nums2, k - i);
            int[] temRes = mergeSequence(sequence1, sequence2);
            for (int j = 0; j < k; j++) {
                if (res[j] > temRes[j]) break;
                else if (res[j] < temRes[j]) {
                    res = temRes;
                    break;
                }
            }
        }
        return res;
    }

    private int[] getSequence(int[] nums, int k) {
        int[] res = new int[k];
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            while (index != -1 && res[index] < nums[i] && (nums.length - i > res.length - index - 1)) {
                index--;
            }
            if (index + 1 == k) {
                continue;
            }
            res[++index] = nums[i];
        }
        return res;
    }

    private int[] mergeSequence(int[] seq1, int[] seq2) {
        if (seq1.length == 0) {
            return seq2;
        } else if (seq2.length == 0) {
            return seq1;
        } else {
            int[] res = new int[seq1.length + seq2.length];
            int i1 = 0, i2 = 0, i = 0;
            while (i1 < seq1.length || i2 < seq2.length) {
                if (i1 >= seq1.length) {
                    res[i++] = seq2[i2++];
                } else if (i2 >= seq2.length) {
                    res[i++] = seq1[i1++];
                } else {
                    if (compare(seq1, i1, seq2, i2) > 0) {
                        res[i++] = seq1[i1++];
                    } else {
                        res[i++] = seq2[i2++];
                    }
                }
            }
            return res;
        }
    }

    private int compare(int[] seq1, int i1, int[] seq2, int i2) {
        int x = seq1.length, y = seq2.length;
        while (i1 < x && i2 < y) {
            int difference = seq1[i1] - seq2[i2];
            if (difference != 0) {
                return difference;
            }
            i1++;
            i2++;
        }
        return (x - i1) - (y - i2);
    }
}
