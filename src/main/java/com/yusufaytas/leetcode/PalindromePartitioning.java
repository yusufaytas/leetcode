package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class PalindromePartitioning
{
    public List<List<String>> partition(final String s)
    {
        final List<List<String>> partitions = new ArrayList<>();
        final List<String> current = new LinkedList<>();
        final int[][] visited = new int[s.length()][s.length()];
        partition(partitions, current, visited, s, 0);
        return partitions;
    }

    //0 means not visited, 1 means palindrome, -1 means not a palindrome
    private void partition(final List<List<String>> partitions, final List<String> current,
                           final int visited[][], final String s, final int start)
    {
        if (start >= s.length())
        {
            partitions.add(new ArrayList<>(current));
            return;
        }
        if (visited[start][s.length() - 1] == 0)
        {
            visited[start][s.length() - 1] = isPalindrome(s, start, s.length() - 1);
        }
        for (int i = start; i < s.length(); i++)
        {
            if (visited[start][i] == 0)
            {
                visited[start][i] = isPalindrome(s, start, i);
            }
            if (visited[start][i] == 1)
            {
                final String palindrome = s.substring(start, i + 1);
                current.add(palindrome);
                partition(partitions, current, visited, s, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private int isPalindrome(final String s, final int start, final int end)
    {
        for (int i = 0; i < (end - start + 1) / 2; i++)
        {
            if (s.charAt(start + i) != s.charAt(end - i))
            {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        final String s = "abb";
        System.out.println(new PalindromePartitioning().partition(s));
    }
}
