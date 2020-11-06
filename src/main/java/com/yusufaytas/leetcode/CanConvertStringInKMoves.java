package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given two strings s and t, your goal is to convert s into t in k moves or less.

During the ith (1 <= i <= k) move you can:

    Choose any index j (1-indexed) from s, such that 1 <= j <= s.length and j has not been chosen
    in any previous move, and shift the character at that index i times.
    Do nothing.

Shifting a character means replacing it by the next letter in the alphabet (wrapping around so that 'z' becomes 'a').
Shifting a character by i means applying the shift operations i times.

Remember that any index j can be picked at most once.

Return true if it's possible to convert s into t in no more than k moves, otherwise return false.
 */
public class CanConvertStringInKMoves
{
    public boolean canConvertString(final String s, final String t, int k)
    {
        if(s.length() != t.length())
        {
            return false;
        }
        final List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != t.charAt(i))
            {
                diffs.add((t.charAt(i) - s.charAt(i) + 26) % 26);
            }
        }
        final int[] used = new int[26];
        for (int i = 0; i < diffs.size(); i++)
        {
            int diff = used[diffs.get(i)] == 0 ? diffs.get(i) : used[diffs.get(i)];
            if (diff > k)
            {
                return false;
            }
            used[diffs.get(i)] = diff + 26;
        }
        return true;
    }

    public static void main(String[] args)
    {
        final String s = "aab";
        final String t = "bbb";
        final int k = 27;
        System.out.println(new CanConvertStringInKMoves().canConvertString(s, t, k));
    }
}
