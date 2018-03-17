package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
add spaces in s to construct a sentence where each word is a valid dictionary word.
You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreak2
{
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        Dictionary dictionary = new Dictionary(wordDict);
        List<String> finalSentences = new ArrayList<String>();
        Map<String, List<List<String>>> subSentences = new HashMap<String, List<List<String>>>();
        List<List<String>> fullSentences = findSentences(dictionary, s, 0, subSentences);
        for (List<String> fullSentence : fullSentences)
        {
            finalSentences.add(String.join(" ", fullSentence));
        }
        return finalSentences;
    }

    private List<List<String>> findSentences(Dictionary dictionary, String s, int index, Map<String, List<List<String>>> subSentences)
    {
        if (s.length() == index)
        {
            List<String> seed = new ArrayList<String>();
            List<List<String>> newSeed = new ArrayList<List<String>>();
            newSeed.add(seed);
            return newSeed;
        }
        if (subSentences.containsKey(s.substring(index)))
        {
            return subSentences.get(s.substring(index));
        }
        int currentIndex = index + 1;
        List<Integer> candidates = new ArrayList<Integer>();
        while (currentIndex <= s.length())
        {
            String currentString = s.substring(index, currentIndex);
            if (dictionary.isInDictionary(currentString))
            {
                candidates.add(currentIndex);
            }
            currentIndex++;
        }
        List<List<String>> currentSentences = new ArrayList<List<String>>();
        for (Integer candidateIndex : candidates)
        {
            String currentString = s.substring(index, candidateIndex);
            String remainingString = s.substring(candidateIndex);
            List<List<String>> allPossibleSentences = findSentences(dictionary, s, candidateIndex, subSentences);
            if (remainingString.length() != 0)
            {
                subSentences.put(s.substring(candidateIndex), allPossibleSentences);
            }
            for (List<String> possibleSentence : allPossibleSentences)
            {
                List<String> currentSentence = new ArrayList<String>(possibleSentence);
                currentSentence.add(0, currentString);
                currentSentences.add(currentSentence);
            }
        }
        return currentSentences;
    }


    private class Dictionary
    {
        private boolean isWord;
        private Map<String, Dictionary> nodes = new HashMap<String, Dictionary>();

        public Dictionary()
        {
        }

        public Dictionary(List<String> wordDict)
        {
            for (String word : wordDict)
            {
                Dictionary currentNode = this;
                for (int i = 0; i < word.length(); i++)
                {
                    String value = word.charAt(i) + "";
                    if (!currentNode.nodes.containsKey(value))
                    {
                        Dictionary newNode = new Dictionary();
                        currentNode.nodes.put(value, newNode);
                        currentNode = newNode;
                    }
                    else
                    {
                        currentNode = currentNode.nodes.get(value);
                    }
                }
                currentNode.isWord = true;
            }

        }

        boolean isInDictionary(String word)
        {
            return isInDictionary(this, word);
        }

        boolean isInDictionary(Dictionary n, String w)
        {
            if (w.length() == 0)
            {
                return n.isWord;
            }
            String currentChar = w.charAt(0) + "";
            if (n.nodes.containsKey(currentChar))
            {
                return isInDictionary(n.nodes.get(currentChar), w.substring(1));
            }
            return false;
        }
    }

    public static void main(String[] args)
    {
        final String s = "catsanddog";
        final List<String> wordDict = new ArrayList<String>();
        Collections.addAll(wordDict, "cat", "cats", "and", "sand", "dog");

        System.out.println(new WordBreak2().wordBreak(s, wordDict));
    }
}
