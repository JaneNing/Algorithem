package com.jane_Plus.algorithem.leetcode;

public class LemonadeChange {
    public boolean lemonadeChange_860(int[] bills) {
        int ten = 0;
        int five =0;
        int i = 0;
        while(i<bills.length){
            if(bills[i] ==5){
                five++;
            }else if(bills[i] ==10){
                if(--five>=0){
                    ten++;
                }else{
                    break;
                }
            }else{
                if(ten-1>=0){
                    ten--;
                    if(--five<0){
                        break;
                    }
                }else if(five-3>=0){
                    five-=3;
                }
                else{
                    break;
                }
            }
            i++;
        }
        return i >= bills.length;

    }
}
