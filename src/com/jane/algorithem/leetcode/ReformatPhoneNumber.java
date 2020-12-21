package com.jane.algorithem.leetcode;

public class ReformatPhoneNumber {

    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "").replaceAll("-", "");
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length() - 4; i += 3) {
            builder.append(number.substring(i, i + 3)).append("-");
            index = i + 3;
        }
        if (number.length() - index == 2 || number.length() - index == 3) {
            builder.append(number.substring(index));
        } else {
            builder.append(number.substring(index, index + 2)).append("-").append(number.substring(index + 2));
        }
        return builder.toString();
    }
}
