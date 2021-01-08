package com.jane.algorithem.leetcode;

public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for(String s  : word1){
            builder1.append(s);
        }
        for(String s : word2){
            builder2.append(s);
        }
        return builder1.toString().equals(builder2.toString());
    }
}
