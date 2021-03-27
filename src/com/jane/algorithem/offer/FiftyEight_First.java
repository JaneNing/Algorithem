package com.jane.algorithem.offer;

public class FiftyEight_First {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals(" ") || s1[i].equals("")) continue;
            if (builder.length() == 0) {
                builder.append(s1[i].replaceAll(" ", ""));
            } else {
                builder.append(" ").append(s1[i].replaceAll(" ", ""));
            }
        }
        return builder.toString();
    }
}
