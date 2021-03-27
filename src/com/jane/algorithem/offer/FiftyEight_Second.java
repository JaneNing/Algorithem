package com.jane.algorithem.offer;

public class FiftyEight_Second {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
