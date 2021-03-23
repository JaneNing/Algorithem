package com.jane.algorithem.offer;

public class FortyThree {

    public static void main(String[] args) {
        FortyThree fortyThree = new FortyThree();
        fortyThree.countDigitOne(109);
    }

    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int cur = Integer.parseInt(s.charAt(i) + "");
            int pow = (int) Math.pow(10, len - i - 1);
            if (cur == 0) {
                int pre = Integer.parseInt(s.substring(0, i));
                res += pre * pow;
            } else if (cur == 1) {
                int pre = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));
                int next = i == len - 1 ? 0 : Integer.parseInt(s.substring(i + 1, len));
                res += pre * pow + next + 1;
            } else {
                int pre = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));
                res += (pre + 1) * pow;
            }
        }
        return res;
    }
}
