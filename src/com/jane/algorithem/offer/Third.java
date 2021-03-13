package com.jane.algorithem.offer;

public class Third {

    public int findRepeatNumber(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] nums, int l, int r) {
        if (r <= l) return 0;
        int num = nums[l];
        int ll = l + 1, rr = r;
        while (ll <= rr) {
            while (ll <= r && nums[ll] < num) {
                ll++;
            }
            if (ll <= r && nums[ll] == num) return num;
            while (rr > l && nums[rr] > num) {
                rr--;
            }
            if (rr > l && nums[rr] == num) return num;
            if (rr <= ll) break;
            int tem = nums[rr];
            nums[rr] = nums[ll];
            nums[ll] = tem;
        }
        int tem = nums[l];
        nums[l] = nums[rr];
        nums[rr] = tem;
        int res = sort(nums, l, rr - 1);
        if (res != 0) return res;
        res = sort(nums, rr + 1, r);
        if (res != 0) return res;
        return 0;
    }
}
