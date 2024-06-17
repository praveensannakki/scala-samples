package com.leetcode.string;


import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * 58. Length of Last Word
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 *
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 *
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("length of last word of Hello World: " + lengthOfLastWord("Hello World"));
        System.out.println("length of last word of    fly me   to   the moon  : " + lengthOfLastWordLambda("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        return s.split(" ")[s.split(" ").length - 1].trim().length();
    }

    public static int lengthOfLastWordLambda(String s) {
         Arrays.stream(s.split(" "))
                .skip(s.split(" ").length - 1)
                .findFirst()
                .ifPresent(lastElement -> System.out.println("Last element using Stream: " + lastElement));

         return Arrays.stream(s.split(" "))
                 .reduce((first, second) -> second)
                 .map(String::length)
                 .orElse(0);
    }
}
