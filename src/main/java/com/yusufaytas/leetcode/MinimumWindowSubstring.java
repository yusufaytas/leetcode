package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string S and a string T,
find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring
{
    public String minWindow(String s, String t)
    {
        Map<Character, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
        {
            indexes.put(t.charAt(i), new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++)
        {
            char value = s.charAt(i);
            if (indexes.containsKey(value))
            {
                indexes.get(value).add(i);
            }
        }
        if (indexes.values().stream().filter(value -> value.size() > 0).count() != t.length())
        {
            return "";
        }
        Map<Character, Integer> index = new HashMap<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // A = 4, 5, 13,
        // B = 2, 6, 9, 14
        // C = 8, 10, 11, 12

        // (A=0, B=0, C=0)=>6, (A=0, B=1, C=0)=>4, (A=1, B=1, C=0)=>4 |
        // (A=2, B=2, C=1)=>4, A
        for (int i : index.values())
        {
            if (i > max)
            {
                max = i;
            }
            if (i < min)
            {
                min = i;
            }
        }
        return s.substring(min, max);
    }

    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
