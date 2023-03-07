package com.jane.algorithem.leetcode;

public class CheckIfWordEqualsSummationOfTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        long num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            num1 = num1 * 10 + firstWord.charAt(i) - 'a';
        }
        for (int i = 0; i < secondWord.length(); i++) {
            num2 = num2 * 10 + secondWord.charAt(i) - 'a';
        }
        for (int i = 0; i < targetWord.length(); i++) {
            num3 = num3 * 10 + targetWord.charAt(i) - 'a';
        }
        return num1 + num2 == num3;
    }
}
