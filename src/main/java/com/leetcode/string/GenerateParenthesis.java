package com.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println("generate parenthesis for 3: "+ new GenerateParenthesis().generateParenthesis(2));
        System.out.println("generate parenthesis for 3: "+ new GenerateParenthesis().generateParenthesisFromLeetCode(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        builder(result, n, 0, "");
        return result;
    }

    private void builder(List<String> result, int left, int right, String s) {
        //System.out.println("left: " + left + " right: " + right + " s: " + s);
        if(left == 0 && right == 0) {
            result.add(s);
            //System.out.println("gdsleft: " + left + " right: " + right + " s: " + s);
            return;
        }

        if(left > 0) builder(result, left - 1, right + 1, s + "(");
        if(right > 0) builder(result, left, right - 1, s + ")");
    }


    public List<String> generateParenthesisFromLeetCode(int n) {
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }

        List<String> answer = new ArrayList<>();
        for (int leftCount = 0; leftCount < n; ++leftCount) {
            //System.out.println("leftCount: " + leftCount + ", n: " + n);
            for (String leftString : generateParenthesisFromLeetCode(leftCount)) {
                //System.out.println("leftString: " + leftString + ", leftCount: " + leftCount);
                for (String rightString : generateParenthesisFromLeetCode(n - 1 - leftCount)) {
                    //System.out.println("leftCount: " + leftCount + " leftString: " + leftString + " rightString: " + rightString);
                    answer.add("(" + leftString + ")" + rightString);
                }
            }
        }


        return answer;
    }
}
