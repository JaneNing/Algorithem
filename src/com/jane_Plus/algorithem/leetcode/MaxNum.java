package com.jane_Plus.algorithem.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MaxNum {
    public static void main(String[] args) {


        int[] num1 = new int[]{2,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,0,6
        };
        int[] num2 = new int[]{1,1,1,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,4,0
        };
        System.out.println(Arrays.toString(new MaxNum().algorithm_321(num1, num2, 600)));
    }
    public int[] algorithm_321(int[] nums1, int[] nums2, int k) {
        if (k <= 0||k>nums1.length+nums2.length) {
            return null;
        }
        int[] res = new int[k];
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            int[] merge = merge(nums1, nums2, k, i);
            if (compare(merge, res,k)>0) {
                res = merge;
            }
        }
        return res;
    }


    private int[] merge(int[] nums1, int[] nums2,int k,int num1) {
        int num2 = k - num1;
        int[] maxNum1 = new int[num1+1];
        int[] maxNum2 = new int[num2+1];
        int n1 = findMax(nums1, num1, maxNum1);
        int n2 = findMax(nums2, num2, maxNum2);
        int[] res = new int[k];
        if (n1 + n2 != k) {
            return res;
        }
        int index1=0,index2=0;
        int i = 0;
        while (i < k) {
            int x = index1, y = index2;
            while (x < n1 && y < n2) {
                if (maxNum1[x] > maxNum2[y]) {
                    res[i++] = maxNum1[index1++];
                    break;
                } else if (maxNum1[x] < maxNum2[y]) {
                    res[i++] = maxNum2[index2++];
                    break;
                }else {
                    if (x + 1 == n1 && y + 1 == n2) {
                        res[i++] = maxNum1[index1++];
                        res[i++] = maxNum2[index2++];
                        ++x;
                        ++y;
                        continue;
                    }
                    if (x+1!=n1) {
                        ++x;
                    }
                    if (y+1 != n2) {
                        ++y;
                    }

                }
            }
            if (index1 == n1 || index2 == n2) {
                break;
            }
        }
        if (index1 < n1) {
            while (index1 < n1) {
                res[i++] = maxNum1[index1++];
            }
        }
        if (index2 < n2) {
            while (index2 < n2) {
                res[i++] = maxNum2[index2++];
            }
        }
        return res;
    }
    private int findMax(int[] nums, int num, int[] maxNum) {
        int mark = 0;
        if (num > 0 && nums.length >= num) {
            for (int i = 0; i < nums.length; i++) {
                while (mark>0 && maxNum[mark-1] < nums[i] && mark + nums.length - i > num) {
                    mark--;
                }
                if (mark < num) {
                    maxNum[mark]=nums[i];
                    mark++;
                }
            }
        }
        return mark;
    }
    private Integer compare(int[] a, int[] b ,int k) {
        for (int i = 0; i < k; i++) {
            if (a[i] > b[i]) {
                return 1;
            } else if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0;
    }
}
