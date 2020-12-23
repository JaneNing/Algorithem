package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            arr[i] = s.charAt(i) - '0';
        }
        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i] - arr[i+1] < 0) break;
            if(i == arr.length - 2) return -1;
        }
        int index = -1;
        for(int i = arr.length -1 ; i > 0 ; i--){
            if(arr[i] - arr[i-1] > 0){
                index = i;
                break;
            }
        }
        int swapIndex = -1;
        for(int i = index ; i < arr.length ; i++){
            if(arr[i] > arr[index-1]){
                swapIndex = i;
            }else{
                break;
            }
        }
        int tem = arr[index - 1];
        arr[index - 1] = arr[swapIndex];
        arr[swapIndex] = tem;
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < index ; i++){
            builder.append("" + arr[i]);
        }
        int[] temArr = new int[arr.length - index];
        for(int i = index ; i < arr.length ; i++){
            temArr[i - index] = arr[i];
        }
        Arrays.sort(temArr);
        for(int i = 0 ; i < temArr.length ; i++){
            builder.append("" + temArr[i]);
        }
        long res = Long.parseLong(builder.toString());
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
}
