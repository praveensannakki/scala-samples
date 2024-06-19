package com.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortTheSentence {
    public static void main(String[] args) {
        System.out.println("sort sentence: " + new SortTheSentence().sortSentence("is2 sentence4 This1 a3"));
        System.out.println("sort sentence: " + sortSentenceWithMap("is2 sentence4 This1 a3"));
    }
    public String sortSentence(String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // Sort the words based on the appended number
        Arrays.sort(words, (a, b) -> {
            int numA = Integer.parseInt(a.replaceAll("\\D", ""));
            int numB = Integer.parseInt(b.replaceAll("\\D", ""));
            return Integer.compare(numA, numB);
        });

        // Remove the numbers from the sorted words
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\d", "");
        }

        // Join the words back into a sentence
        return String.join(" ", words);
    }

    public static String sortSentenceWithMap(String s) {
        String[] words = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(words).forEach(word -> {
            map.put(Integer.parseInt(String.valueOf(word.charAt(word.length() -1))), word.substring(0, word.length() -1));
        });

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (int i = 1; i <= words.length; i++) {
            words[i - 1] = map.get(i);
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());

        return String.join(" ", words);
    }
}
