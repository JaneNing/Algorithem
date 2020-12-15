package com.jane.algorithem.leetcode;

public class DotaTwoSenate {

    public String predictPartyVictory(String senate) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                n1++;
            } else {
                n2++;
            }
        }
        StringBuilder builder = new StringBuilder(senate);
        while (n1 > 0 && n2 > 0) {
            StringBuilder temBuilder = new StringBuilder();
            int a1 = 0, a2 = 0;
            for (int i = 0; i < builder.length(); i++) {
                char c = builder.charAt(i);
                if (c == 'R') {
                    if (a2 == 0) {
                        a1++;
                        temBuilder.append('R');
                        n2--;
                    } else {
                        a2--;
                    }
                } else {
                    if (a1 == 0) {
                        a2++;
                        temBuilder.append('D');
                        n1--;
                    } else {
                        a1--;
                    }
                }
            }
            if (a1 > 0) {
                StringBuilder builder1 = new StringBuilder();
                for (int i = 0; i < temBuilder.length(); i++) {
                    if (temBuilder.charAt(i) == 'D' && a1 != 0) {
                        a1--;
                    } else {
                        builder1.append(temBuilder.charAt(i));
                    }
                }
                temBuilder = builder1;
            } else if (a2 > 0) {
                StringBuilder builder1 = new StringBuilder();
                for (int i = 0; i < temBuilder.length(); i++) {
                    if (temBuilder.charAt(i) == 'R' && a2 != 0) {
                        a2--;
                    } else {
                        builder1.append(temBuilder.charAt(i));
                    }
                }
                temBuilder = builder1;
            }
            builder = temBuilder;
        }
        return builder.charAt(0) == 'D' ? "Dire" : "Radiant";
    }
}
