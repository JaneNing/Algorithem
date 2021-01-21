package com.jane_Plus.algorithem.leetcode;

import java.util.Arrays;

public class BreakFastNumber {
    public int breakfastNumber_18(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int m = staple.length, n = drinks.length;
        int i=0,j=n-1;
        while (i < m && j >= 0) {
            if (staple[i]+drinks[j]<=x){
                res=(res+j+1)%1000000007;
                i++;
            }else {
                j--;
            }
        }
        return res%1000000007;
    }
}

