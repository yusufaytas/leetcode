package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lower-case English letters.


 */
public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(final String[] strs)
    {
        final List<List<String>> groupedAnagrams = new ArrayList<>();
        final Map<Map<Character, Integer>, Integer> groupIndex = new HashMap<>();
        for (int i = 0; i < strs.length; i++)
        {
            final Map<Character, Integer> letterSet = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++)
            {
                letterSet.put(strs[i].charAt(j), letterSet.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            final int index = groupIndex.getOrDefault(letterSet, groupedAnagrams.size());
            if (index == groupedAnagrams.size())
            {
                groupedAnagrams.add(new ArrayList<>());
                groupIndex.put(letterSet, index);
            }
            groupedAnagrams.get(index).add(strs[i]);
        }
        return groupedAnagrams;
    }
}
