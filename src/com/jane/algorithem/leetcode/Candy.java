package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Candy {

    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 1){
            return 1;
        }
        int[] arr = new int[len];
        List<Integer> list = new ArrayList();
        for(int i = 0 ; i < len ; i++){
            if(i == 0){
                if(ratings[i] <= ratings[i+1]){
                    list.add(i);
                }
            }else if(i == len - 1){
                if(ratings[i] <= ratings[i-1]){
                    list.add(i);
                }
            }else if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
                list.add(i);
            }
        }
        for(int j = 0 ; j < list.size() ; j++){
            int index = list.get(j);
            arr[index] = 1;
            for(int i = index - 1 ; i >= 0 ; i--){
                if(ratings[i] > ratings[i+1]){
                    arr[i] = Math.max(arr[i] , arr[i + 1] + 1);
                }else if(ratings[i] >= ratings[i+1]){
                    arr[i] = Math.max(arr[i] , 1);
                }else{
                    break;
                }
            }
            for(int i = index + 1 ; i < len ; i++){
                if(ratings[i] > ratings[i-1]){
                    arr[i] = Math.max(arr[i] , arr[i - 1] + 1);
                }else if(ratings[i] >= ratings[i-1]){
                    arr[i] = Math.max(arr[i] , 1);
                }else{
                    break;
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < len ; i ++){
            res += arr[i];
        }
        return res;
    }
}
