package com.yusufaytas.leetcode;

/*
{{REVISIT}}
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"

Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() == 0)
        {
            return "";
        }

        String maxPalindrome = "";
        boolean[][] palindromes = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            palindromes[i][i] = true;
            maxPalindrome = s.substring(i, i + 1);
        }

        for (int i = 0; i < s.length() - 1; i++)
        {
            palindromes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (palindromes[i][i + 1])
            {
                maxPalindrome = s.substring(i, i + 2);
            }
        }

        for (int j = 2; j < s.length(); j++)
        {
            for (int i = 0; i + j < s.length(); i++)
            {
                palindromes[i][i + j] = s.charAt(i) == s.charAt(i + j) && palindromes[i + 1][i + j - 1];
                if (j + 1 > maxPalindrome.length() && palindromes[i][i + j])
                {
                    maxPalindrome = s.substring(i, i + j + 1);
                }
            }
        }
        return maxPalindrome;
    }

}
