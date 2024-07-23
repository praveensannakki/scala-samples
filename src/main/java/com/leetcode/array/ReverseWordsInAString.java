package com.leetcode.array;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("reverse words: " + reverseWords("the sky is  blue"));
        System.out.println("reverse words: " + reverseWordsWithStreams("the sky is  blue"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWordsWithStreams(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(" "))
                .filter(word -> !word.isEmpty())
                .forEach(word -> sb.insert(0, word.trim() + " "));
        return sb.toString().trim();
    }

}
