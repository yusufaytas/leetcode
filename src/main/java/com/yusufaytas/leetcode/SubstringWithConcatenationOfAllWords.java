package com.yusufaytas.leetcode;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class SubstringWithConcatenationOfAllWords
{
    public List<Integer> findSubstring(String s, String[] words)
    {
        if (s == null || s.isEmpty() || words == null || words.length == 0)
        {
            return Collections.emptyList();
        }
        int size = words[0].length();
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
        {
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word, count + 1);
        }

        for (int i = 0; i < size; i++)
        {
            int windowSize = 0;
            Map<String, Integer> window = new HashMap<>();
            for (int j = 0; i + (j + 1) * size <= s.length(); j++)
            {
                String sub = s.substring(i + j * size, i + (j + 1) * size);
                if (!wordCount.containsKey(sub))
                {
                    window.clear();
                    windowSize = 0;
                }
                windowSize++;
                window.put(sub, window.getOrDefault(sub, 0) + 1);
                boolean isFound = true;
                for (String word : wordCount.keySet())
                {
                    if (wordCount.get(word) != window.get(word))
                    {
                        isFound = false;
                        break;
                    }
                }
                int startIndex = i + (j + 1 - words.length) * size;
                if (isFound)
                {
                    indexes.add(startIndex);
                }
                if (windowSize == words.length)
                {
                    String startSub = s.substring(startIndex, startIndex + size);
                    int count = window.get(startSub);
                    if (count == 1)
                    {
                        window.remove(startSub);
                    }
                    else
                    {
                        window.put(startSub, count - 1);
                    }
                    windowSize--;
                }
            }
        }

        return indexes;
    }

    public static void main(String[] args)
    {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        LocalDateTime start = LocalDateTime.now();
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
        LocalDateTime end = LocalDateTime.now();
        System.out.println(ChronoUnit.MILLIS.between(start, end));
    }
}
