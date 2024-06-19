package com.leetcode.array;

// Constant contact

// Given a x by y matrix, write code to check if the matrix is symmetrical either vertically, horizontally, or both.
// Assume that the matrix is valid (all rows have the same number of entries, etc) and that the matrix is not empty.

// matrix = [[1, 0, 0],
//           [0, 0, 0]
//           [0, 0, 1]] => None

// matrix = [[1, 0, 1],
//           [0, 0, 1],
//           [0, 0, 1],
//           [0, 0, 1],
//           [1, 0, 1]] => Horizontal

// matrix = [[1, 0, 1],
//           [0, 0, 1],
//           [0, 0, 1],
//           [1, 0, 1]] => Horizontal

// matrix = [[1, 0, 1],
//           [1, 0, 1],
//           [0, 0, 0]] => Vertical

// matrix = [[1, 0, 1],
//           [0, 0, 0],
//           [1, 0, 1]] => Both

import java.util.Arrays;

public class MatrixSymmetry {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[][] matrix2 = {
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {1, 0, 1}
        };
        int[][] matrix3 = {
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {1, 0, 1}
        };
        int[][] matrix4 = {
                {1, 0, 1},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] matrix5 = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        System.out.println(findSymmetry(matrix1)); // None
        System.out.println(findSymmetry(matrix2)); // Horizontal
        System.out.println(findSymmetry(matrix3)); // Horizontal
        System.out.println(findSymmetry(matrix4)); // Vertical
        System.out.println(findSymmetry(matrix5)); // Both
    }

    public static String findSymmetry(int[][] matrix) {
        boolean isHorizontal = checkHorizontalSymmetry(matrix);
        boolean isVertical = checkVerticalSymmetry(matrix);

        if (isHorizontal && isVertical) {
            return "Both";
        } else if (isHorizontal) {
            return "Horizontal";
        } else if (isVertical) {
            return "Vertical";
        } else {
            return "None";
        }
    }

    private static boolean checkHorizontalSymmetry(int[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < rows/2; i++) {
                if (!Arrays.equals(matrix[i], matrix[rows -1 -i])) {
                    return false;
            }
        }
        return true;
    }

    private static boolean checkVerticalSymmetry(int[][] matrix) {
        int cols = matrix[0].length;
        for (int i = 0; i < cols / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != matrix[j][cols - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
