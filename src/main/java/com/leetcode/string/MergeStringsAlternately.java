package com.leetcode.string;

//1768. Merge Strings Alternately

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqrst"));
        System.out.println(mergeAlternately2("abc", "pqrst"));
    }

    private static String mergeAlternately(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< s1.length() && i< s2.length(); i++) {
            sb.append(s1.charAt(i)).append(s2.charAt(i));
        }

        if(s1.length() > s2.length()) {
            sb.append(s1.substring(s2.length()));
        } else {
            sb.append(s2.substring(s1.length()));
        }

        return sb.toString();
    }

    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int m = word1.length();
        int n = word2.length();

        for (int i =0; i < Math.max(m,n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
