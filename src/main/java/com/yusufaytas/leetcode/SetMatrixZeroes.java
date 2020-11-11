package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */
public class SetMatrixZeroes
{
    public void setZeroes(final int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
        {
            return;
        }
        final Set<Integer> zeroColumns = new HashSet<>();
        final Set<Integer> zeroRows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    zeroColumns.add(j);
                    zeroRows.add(i);
                }
            }
        }
        for (final int i : zeroRows)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = 0;
            }
        }
        for (final int j : zeroColumns)
        {
            for (int i = 0; i < matrix.length; i++)
            {
                matrix[i][j] = 0;
            }
        }
    }

}
