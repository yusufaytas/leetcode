package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.printMatrix;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage
{
    public void rotate(final int[][] matrix)
    {
        int increment = 0;
        while (increment <= matrix.length / 2)
        {
            for (int i = increment; i < matrix.length - increment - 1; i++)
            {
                final int temp = matrix[increment][i];
                matrix[increment][i] = matrix[matrix.length - 1 - i][increment];
                matrix[matrix.length - 1 - i][increment] = matrix[matrix.length - 1 - increment][matrix.length - 1 - i];
                matrix[matrix.length - 1 - increment][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - increment];
                matrix[i][matrix.length - 1 - increment] = temp;
            }
            increment++;
        }
    }

    public static void main(String[] args)
    {
        final int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new RotateImage().rotate(matrix);
        printMatrix(matrix);
    }
}
