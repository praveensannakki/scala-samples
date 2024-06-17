package com.leetcode.string;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("Longest common prefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("Longest common prefix with sorting: " + longestCommonPrefixWithSorting(new String[]{"flower", "flow", "flight"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return prefix.substring(0, i);
                }

            }

        }
        return prefix;
    }

    public static String longestCommonPrefixWithSorting(String[] strs) {
        Arrays.sort(strs, (a,b) -> Integer.compare(a.length(), b.length()));
        for (int i = 0; i < strs[0].length(); i++) {
            if(i == strs[1].length() || strs[0].charAt(i) != strs[1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
