package com.yusufaytas.leetcode;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list,
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder2
{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        Map<String, Set<String>> graph = constructGraph(beginWord, endWord, new HashSet<>(wordList));
        List<List<String>> paths = findPaths(beginWord, endWord, graph);
        return paths;
    }

    private List<List<String>> findPaths(String beginWord, String endWord, Map<String, Set<String>> graph)
    {
        Queue<List<String>> paths = new LinkedList<>();
        List<List<String>> ladders = new ArrayList<>();
        List<String> firstNode = new ArrayList<>();
        firstNode.add(beginWord);
        paths.add(firstNode);

        while (!paths.isEmpty())
        {
            List<String> path = paths.poll();
            String current = path.get(path.size() - 1);
            Set<String> neighbours = graph.get(current);
            if(neighbours == null || neighbours.isEmpty())
            {
                continue;
            }
            else if(neighbours.contains(endWord))
            {
                List<String> ladder = new ArrayList<>(path);
                ladder.add(endWord);
                ladders.add(ladder);
            }
            else
            {
                for(String neighour : neighbours)
                {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighour);
                    paths.add(newPath);
                }
            }
        }

        return ladders;
    }

    private Map<String, Set<String>> constructGraph(String beginWord, String endWord, Set<String> words)
    {
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> currentSet = new HashSet<>();
        currentSet.add(beginWord);

        boolean isFound = false;

        while (!isFound && !currentSet.isEmpty() && !words.isEmpty())
        {
            Set<String> newSet = new HashSet<>();
            words.removeAll(currentSet);
            for (String word : currentSet)
            {
                Set<String> neighbours = getNeighbours(word, words);
                newSet.addAll(neighbours);
                if (newSet.contains(endWord))
                {
                    isFound = true;
                }
                graph.put(word, neighbours);
            }
            currentSet = newSet;
        }

        return graph;
    }

    private Set<String> getNeighbours(String word, Set<String> words)
    {
        Set<String> neighbours = new HashSet<>();
        char[] wordChars = word.toCharArray();
        for (char ch = 'a'; ch < 'z'; ch++)
        {
            for (int i = 0; i < wordChars.length; i++)
            {
                if (wordChars[i] != ch)
                {
                    char current = wordChars[i];
                    wordChars[i] = ch;
                    String neighbour = new String(wordChars);
                    if (words.contains(neighbour))
                    {
                        neighbours.add(neighbour);
                    }
                    wordChars[i] = current;
                }
            }
        }
        return neighbours;
    }

    public static void main(String[] args)
    {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, "hot","dot","dog","lot","log");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(new WordLadder2().findLadders(beginWord, endWord, wordList));
        LocalDateTime endTime = LocalDateTime.now();

        System.out.println(ChronoUnit.MILLIS.between(startTime, endTime));
        //["cet","get","gee","gte","ate","ats","its","ito","ibo","ibm","ism"]
        //["cet","cat","can","ian","inn","ins","its","ito","ibo","ibm","ism"]
        //["cet","cot","con","ion","inn","ins","its","ito","ibo","ibm","ism"]
    }
}
