package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatrixRowColumnPairs {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println(countMatrixPairs(matrix2));
        System.out.println(countMatrixPairsWithMap(matrix2));
    }

    private static int countMatrixPairsWithMap(int[][] matrix) {
        int count =0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            return count;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString, 0) + 1);
        }

        for (int c=0; c < cols; c++) {
            int[] col = new int[cols];
            for (int r =0; r < cols; r++) {
                col[r] = matrix[r][c];
            }
            count += map.getOrDefault(Arrays.toString(col), 0);
        }

        return count;
    }

    private static int countMatrixPairs(int[][] matrix) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            return count;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean match = true;
                for ( int i = 0; i < rows; i++) {
                    if (matrix[r][i] != matrix[i][c]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    count++;
                }

            }
        }

        return count;
    }
}
