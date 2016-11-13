package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring
{
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null)
        {
            return 0;
        }
        int maxLengthSoFar = 0;
        for (int i = 0; i < s.length(); i++)
        {
            Set<Character> longestSubString = new HashSet<Character>();
            for (int j = i; j < s.length(); j++)
            {
                char c = s.charAt(j);
                if (longestSubString.contains(c))
                {
                    break;
                }
                longestSubString.add(c);
            }
            if (maxLengthSoFar < longestSubString.size())
            {
                maxLengthSoFar = longestSubString.size();
            }
        }
        return maxLengthSoFar;
    }

    public static void main(String[] args)
    {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
    }
}

