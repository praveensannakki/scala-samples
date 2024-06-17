package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */
public class CheckValidParentheses {
    public static void main(String[] args) {
        System.out.println("isValidParentheses: " + isValidCase("(){}[]"));
        System.out.println("isValidParentheses: " + isValidCase2("([])"));
        System.out.println("isValidParentheses: " + isValidP("([)"));
    }

    private static boolean isValidCase(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            switch(c) {
                case ')' : if(stack.isEmpty() || stack.pop() != '(') return false; break;
                case ']' : if(stack.isEmpty() || stack.pop() != '[') return false; break;
                case '}' : if(stack.isEmpty() || stack.pop() != '{') return false; break;
                default: stack.push(c); break;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValidP(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Stream.of(new Character[][]{
                {'(', ')'},
                {'{', '}'},
                {'[', ']'}}
        ).collect(Collectors.toMap(data -> data[1], data -> data[0]));
        boolean result = true;
        for (char c : s.toCharArray()) {
            if (c == '(' || c =='{' || c =='[')
                stack.push(c);
            else
                result = (stack.isEmpty() || stack.pop() != map.get(c)) ? false : true;
        }
        return result && stack.isEmpty();
    }

    private static boolean isValidCase2(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(' :
                case '{' :
                case '[' :
                    stack.push(c);
                    break;
                default : if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    result = false;
                    break;
                }
            }
        }
        return stack.isEmpty() && result;
    }
}
