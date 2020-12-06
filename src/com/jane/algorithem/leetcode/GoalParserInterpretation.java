package com.jane.algorithem.leetcode;

public class GoalParserInterpretation {

    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                if(command.charAt(i+1)==')'){
                    stringBuilder.append("o");
                    i+=1;
                }else{
                    stringBuilder.append("al");
                    i+=3;
                }
            }else{
                stringBuilder.append("G");
            }
        }
        return stringBuilder.toString();
    }
}
