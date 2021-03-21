package com.jane.algorithem.offer;

public class ThirtyOne {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] arr = new int[pushed.length];
        int i1 = -1, i2 = 0, i3 = 0;
        while (i3 != popped.length) {
            if (i1 != -1 && arr[i1] == popped[i3]) {
                arr[i1--] = 0;
                i3++;
                continue;
            }
            if (i2 >= pushed.length) return false;
            arr[++i1] = pushed[i2++];
        }
        return true;
    }
}
