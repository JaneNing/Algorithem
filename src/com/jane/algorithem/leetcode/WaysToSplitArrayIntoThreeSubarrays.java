package com.jane.algorithem.leetcode;

public class WaysToSplitArrayIntoThreeSubarrays {

    public int waysToSplit(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = (i == arr.length - 1 ? 0 : arr[i + 1]) + nums[i];
        }
        long total = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int thirdSum = arr[i];
            int[] res = new int[2];
            search(arr, 0, i - 1, thirdSum, res);
            if (res[1] - res[0] + 1 >= 0) {
                total += res[1] - res[0] + 1;
                total %= (int) (1e9 + 7);
            }
        }
        return (int) total;
    }

    private void search(int[] arr, int l, int r, int upLimit, int[] res) {
        int ll = l, rr = r, mid;
        while (ll <= rr) {
            mid = (ll + rr) / 2;
            if (arr[mid] - upLimit <= upLimit) {
                rr = mid - 1;
            } else {
                ll = mid + 1;
            }
        }
        //取ll还是rr+1 如果为0则+1
        res[0] = rr + 1 == 0 ? 1 : rr + 1;
        ll = l;
        rr = r;
        while (ll <= rr) {
            mid = (ll + rr) / 2;
            if (arr[0] - arr[mid] > arr[mid] - upLimit) {
                rr = mid - 1;
            } else {
                ll = mid + 1;
            }
        }
        res[1] = ll - 1;
    }
}
