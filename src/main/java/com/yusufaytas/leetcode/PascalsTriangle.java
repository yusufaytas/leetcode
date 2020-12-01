package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle
{
    public List<List<Integer>> generate(final int numRows)
    {
        final List<List<Integer>> rows = new ArrayList<>();
        if (numRows == 0)
        {
            return rows;
        }
        rows.add(Arrays.asList(1));
        if (numRows == 1)
        {
            return rows;
        }
        rows.add(Arrays.asList(1, 1));
        for (int i = 2; i < numRows; i++)
        {
            final List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            final List<Integer> lastRow = rows.get(rows.size() - 1);
            for (int j = 0; j < lastRow.size() - 1; j++)
            {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            rows.add(row);
        }
        return rows;
    }
}
