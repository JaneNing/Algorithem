package com.x5sh1.leetcode;

public class CheckIfAll1AreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int left = -1;
        int right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] == 0) {
                right++;
                continue;
            }
            if (left < 0) {
                left = right;
            } else {
                int diff = right - left - 1;
                if (diff < k) {
                    return false;
                }
                left = right;
            }
            right++;
        }
        return true;
    }
}
