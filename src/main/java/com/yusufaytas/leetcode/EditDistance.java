package com.yusufaytas.leetcode;

import static com.yusufaytas.leetcode.Utils.min;

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance
{
    /**
     * Levenshtein Distance
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(final String word1, final String word2)
    {
        if (word1.length() == 0 || word2.length() == 0)
        {
            return Math.max(word1.length(), word2.length());
        }
        final int[][] distances = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++)
        {
            distances[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++)
        {
            distances[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++)
        {
            for (int j = 1; j <= word2.length(); j++)
            {
                final int insertionCost = distances[i - 1][j] + 1;
                final int deletionCost = distances[i][j - 1] + 1;
                final int substitutionCost = distances[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                distances[i][j] = min(insertionCost, deletionCost, substitutionCost);
            }
        }
        return distances[word1.length()][word2.length()];
    }

    public static void main(String[] args)
    {
        final String word1 = "horse";
        final String word2 = "ros";
        System.out.println(new EditDistance().minDistance(word1, word2));
    }
}
