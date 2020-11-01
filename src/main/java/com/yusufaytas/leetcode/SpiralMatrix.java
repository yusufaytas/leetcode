package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12],
  [13,14,15,16]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder(final int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
        {
            return Collections.emptyList();
        }
        final int spiralSize = matrix.length * matrix[0].length;
        final List<Integer> spiral = new ArrayList<>(spiralSize);
        int i = 0, j = 0, direction = 0, indexIncrement = 0;
        spiral.add(matrix[0][0]);
        while (spiral.size() != spiralSize)
        {
            if (direction == 0)
            {
                if (j + 1 < matrix[0].length - indexIncrement)
                {
                    j = j + 1;
                }
                else
                {
                    direction = 1;
                    continue;
                }
            }
            if (direction == 1)
            {
                if (i + 1 < matrix.length - indexIncrement)
                {
                    i = i + 1;
                }
                else
                {
                    direction = 2;
                    continue;
                }
            }
            if (direction == 2)
            {
                if (j - 1 >= indexIncrement)
                {
                    j = j - 1;
                }
                else
                {
                    direction = 3;
                    continue;
                }
            }
            if (direction == 3)
            {
                if (i - 1 > indexIncrement)
                {
                    i = i - 1;
                }
                else
                {
                    direction = 0;
                    indexIncrement++;
                    i = indexIncrement;
                    j = indexIncrement;
                    spiral.add(matrix[i][j]);
                    continue;
                }
            }
            spiral.add(matrix[i][j]);
        }
        return spiral;
    }

    public static void main(String[] args)
    {
        final int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
