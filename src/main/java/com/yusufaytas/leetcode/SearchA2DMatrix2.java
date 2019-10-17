package com.yusufaytas.leetcode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.
Given target = 20, return false.

 */
public class SearchA2DMatrix2
{
    public boolean searchMatrix(final int[][] matrix, final int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        return searchMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    public boolean searchMatrix(final int[][] matrix, final int startCol, final int endCol,
                                final int startRow, final int endRow, final int target)
    {
        if (startCol > endCol || startRow > endRow)
        {
            return false;
        }
        final int midCol = (startCol + endCol) / 2;
        final int midRow = (startRow + endRow) / 2;
        if (matrix[midCol][midRow] == target)
        {
            return true;
        }
        else if (matrix[midCol][midRow] > target)
        {
            return searchMatrix(matrix, startCol, midCol - 1, startRow, endRow, target) ||
                        searchMatrix(matrix, startCol, endCol, startRow, midRow - 1, target);
        }
        return searchMatrix(matrix, midCol + 1, endCol, startRow, endRow, target)
                || searchMatrix(matrix, startCol, endCol, midRow + 1, endRow, target);
    }

    public static void main(String[] args)
    {
        final int target = 1;
        final int[][] matrix = {
                {1, 3, 5},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchA2DMatrix2().searchMatrix(matrix, target));
    }
}
