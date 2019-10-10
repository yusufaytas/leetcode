package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString
{
    public List<Integer> findAnagrams(final String s, final String p)
    {
        if(p.length() > s.length())
        {
            return Collections.emptyList();
        }
        final Map<Character, Integer> pCounts = new HashMap<>(p.length());
        final Map<Character, Integer> sCounts = new HashMap<>(p.length());
        final List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < p.length(); i++)
        {
            pCounts.put(p.charAt(i), pCounts.getOrDefault(p.charAt(i), 0) + 1);
            sCounts.put(s.charAt(i), sCounts.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (sCounts.equals(pCounts))
        {
            indexes.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++)
        {
            final int indexValue = sCounts.get(s.charAt(i));
            if (indexValue == 1)
            {
                sCounts.remove(s.charAt(i));
            }
            else
            {
                sCounts.put(s.charAt(i), sCounts.get(s.charAt(i)) - 1);
            }
            sCounts.put(s.charAt(i + p.length()), sCounts.getOrDefault(s.charAt(i + p.length()), 0) + 1);
            if (sCounts.equals(pCounts))
            {
                indexes.add(i + 1);
            }
        }
        return indexes;
    }

}
