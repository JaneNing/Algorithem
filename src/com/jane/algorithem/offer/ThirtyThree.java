package com.jane.algorithem.offer;

public class ThirtyThree {

    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1);
    }

    private boolean recursion(int[] order, int i, int j) {
        if (i < 0 || j >= order.length || i >= j) return true;
        int base = order[j];
        int index = -1;
        for (int k = i; k < j; k++) {
            if (order[k] > base) {
                index = k;
                break;
            }
        }
        if (index == -1) {
            return recursion(order, i, j - 1);
        } else {
            for (int k = index + 1; k < j; k++) {
                if (order[k] < base) return false;
            }
            return recursion(order, i, index - 1) && recursion(order, index, j - 1);
        }
    }
}
