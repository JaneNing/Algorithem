package com.jane.algorithem.offer;

public class Forty {

    public int[] getLeastNumbers(int[] arr, int k) {
        sort(arr);
        for (int i = 0; i < k; i++) {
            int tem = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tem;
            adjust(arr, 0, arr.length - i - 1);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return res;
    }

    private void sort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
    }

    private void adjust(int[] arr, int j, int l) {
        int min;
        while (j * 2 + 1 < l) {
            if (j * 2 + 2 < l) {
                min = Math.min(arr[j * 2 + 1], arr[j * 2 + 2]);
            } else {
                min = arr[j * 2 + 1];
            }
            if (arr[j] <= min) {
                break;
            }
            if (min == arr[j * 2 + 1]) {
                int tem = arr[j * 2 + 1];
                arr[j * 2 + 1] = arr[j];
                arr[j] = tem;
                j = j * 2 + 1;
            } else {
                int tem = arr[j * 2 + 2];
                arr[j * 2 + 2] = arr[j];
                arr[j] = tem;
                j = j * 2 + 2;
            }
        }
    }
}
