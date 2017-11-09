package com.yusufaytas.leetcode;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 */
public class MaximalSquare
{
    public int getMax(int i, int j, char[][] matrix)
    {
        if (matrix[i][j] != '1')
        {
            return 0;
        }
        int max = 0;
        int currentI = i, currentJ = j;
        while (currentI < matrix.length && currentJ < matrix[i].length)
        {
            if (isSquare(i, j, currentI, currentJ, matrix))
            {
                max++;
            }
            currentI++;
            currentJ++;
        }
        return max;
    }

    private boolean isSquare(int lowI, int lowJ, int highI, int highJ, char[][] matrix)
    {
        for (int i = lowI; i <= highI; i++)
        {
            for (int j = lowJ; j <= highJ; j++)
            {
                if (matrix[i][j] != '1')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int maximalSquare(char[][] matrix)
    {
        int max = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                int currentMax = getMax(i, j, matrix);
                if (max < currentMax)
                {
                    max = currentMax;
                }
            }
        }
        return max * max;
    }

}
