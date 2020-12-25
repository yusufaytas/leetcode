package com.yusufaytas.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest.
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.

Follow up:

    Try to solve it in O(n log k) time and O(n) extra space.

 */
public class TopKFrequentWords {

  public List<String> topKFrequent(final String[] words, final int k) {
    return Arrays.asList(words).stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((o1, o2) -> Long.compare(o2.getValue(), o1.getValue()) == 0 ? o1.getKey()
            .compareTo(o2.getKey()) : Long.compare(o2.getValue(), o1.getValue()))
        .limit(k)
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    System.out.println(new TopKFrequentWords().topKFrequent(words, 4));
  }
}
