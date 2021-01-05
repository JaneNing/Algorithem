package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList();
        int num = 0 , len = s.length() , start = -1;
        char criterian = '.';
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c != criterian){
                if(num >= 3){
                    List list = new ArrayList();
                    list.add(start);
                    list.add(i-1);
                    lists.add(list);
                }
                start = i;
                num = 1;
                criterian = c;
            }else{
                num++;
            }
        }
        if(num >= 3){
            List list = new ArrayList();
            list.add(start);
            list.add(len-1);
            lists.add(list);
        }
        return lists;
    }
}