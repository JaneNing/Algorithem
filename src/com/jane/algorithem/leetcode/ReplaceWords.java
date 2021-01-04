package com.jane.algorithem.leetcode;

import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String s : dictionary) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new Node();
                }
                node = node.nodes[c - 'a'];
            }
            node.s = s;
        }
        StringBuilder newSentence = new StringBuilder();
        String[] strings = sentence.split(" ");
        tag:
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            Node node = root;
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                if (node.s != null) {
                    newSentence.append((newSentence.length() != 0 ? " " : "") + node.s);
                    continue tag;
                }
                if (node.nodes[c - 'a'] == null) {
                    newSentence.append((newSentence.length() != 0 ? " " : "") + string);
                    continue tag;
                }
                node = node.nodes[c - 'a'];
            }
            newSentence.append((newSentence.length() != 0 ? " " : "") + string);
        }
        return newSentence.toString();
    }

    private class Node {
        String s;
        Node[] nodes = new Node[26];
    }
}
