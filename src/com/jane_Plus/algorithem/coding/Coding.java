package com.jane_Plus.algorithem.coding;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**

 *
 */
public class Coding {

    public static void main(String[] args) {
        System.out.println(new Coding().factorial(18));
        System.out.println(new Coding().uniquePath_62(19,13));
    }

    public int uniquePath_62(int m, int n) {
        int a =m+n-2;
        int b =m-1;
        double x = factorial(a);
        double y = factorial(a-b);
        double z = factorial(b);
        double res = x / (y * z);
        return (int) res;
    }
    public double factorial(int n){
        return (n>1) ? n*factorial(n-1) : 1;
    }
}
