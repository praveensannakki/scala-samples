package com.java.practice;

/**
 * This is a demo task.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveInteger {
    public static void main(String[] args) {
        System.out.println(smallPositiveInteger(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(smallPositiveInteger(new int[]{1, 2, 3}));
        System.out.println(smallPositiveInteger(new int[]{-1, -3}));
        System.out.println(smallPositiveInteger(new int[]{-1, 1}));

        System.out.println(isDigitLowerUpper("1String"));

        System.out.println(playingGameToFindWord("cdeo",new int[]{3,2,0,1}));
        System.out.println(playingGameToFindWord("cdeenetpi", new int[]{5, 2, 0, 1, 6, 4, 8, 3, 7}));
    }

    public static int smallPositiveInteger(int[] A) {
        // Implement your solution here
        int max = A.length + 1;
        boolean[] found = new boolean[max];
        for (int num : A) {
            if (num > 0 && num < max) {
                found[num-1] = true;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.println(i + " " + found[i]);
            if (!found[i]) {
                return i+1;
            }
        }
        return 1;
    }

        public static String isDigitLowerUpper(String s) {
            char c = s.charAt(0);
            if(Character.isUpperCase(c)) {  // please fix condition
                return "upper";
            } else if(Character.isLowerCase(c)) {  // please fix condition
                return "lower";
            } else if (Character.isDigit(c)) {  // please fix condition
                return "digit";
            } else {
                return "other";
            }
        }

    /**
     * Example test:   ('cdeo', [3, 2, 0, 1])
      * @param S
     * @param A
     * @return
     */
    public static String playingGameToFindWord(String S, int[] A) {
        // Implement your solution here
        int len = A.length;
        StringBuilder message = new StringBuilder();
        boolean[] seen = new boolean[len];
        int current = 0;
        for (int i = 0; i < len; i++) {
            message.append(S.charAt(current));
            seen[current] = true;
            current = A[current];
            if (seen[current]) break;
        }
        return message.toString();
    }

}
