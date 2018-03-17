package com.yusufaytas.leetcode;

import java.util.HashMap;
import java.util.Map;

class Trie
{

    private boolean isWord = false;
    private Map<Character, Trie> nodes = new HashMap<>();

    public Trie()
    {
    }

    public void insert(String word)
    {
        Trie currentNode = this;
        for (int i = 0; i < word.length(); i++)
        {
            char value = word.charAt(i);
            if (!currentNode.nodes.containsKey(value))
            {
                Trie newNode = new Trie();
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

    public boolean search(String word)
    {
        Trie trie = findWord(word);
        return trie != null && trie.isWord;
    }

    public boolean startsWith(String prefix)
    {
        Trie trie = findWord(prefix);
        return trie != null;
    }

    public Trie findWord(String word)
    {
        Trie currentNode = this;
        for (int i = 0; i < word.length(); i++)
        {
            char value = word.charAt(i);
            if (currentNode.nodes.containsKey(value))
            {
                currentNode = currentNode.nodes.get(value);
            }
            else
            {
                return null;
            }
        }
        return currentNode;
    }
}

