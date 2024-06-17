package com.leetcode.array;

/**
 * 74. Search a 2D Matrix
 *
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1,3,5,7},
                {10,11,12,13},
                {14,15,16,17},
        };
        System.out.println("searchMatrix: " + new Search2DMatrix().searchMatrix(matrix, 9)) ;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r =0; r<matrix.length; r++ ) {
            if (target >= matrix[r][0] && target <= matrix[r][matrix[r].length-1]) {
                for(int i=0; i<matrix[r].length; i++) {
                    if(target == matrix[r][i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
