package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int l = 0 , r = people.length - 1 , count = 0;
        Arrays.sort(people);
        while(l <= r){
            if(people[r] + people[l] > limit){
                r--;
                count++;
            }else{
                r--;
                l++;
                count++;
            }
        }
        return count;
    }
}
