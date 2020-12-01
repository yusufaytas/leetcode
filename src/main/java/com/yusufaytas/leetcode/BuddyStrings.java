package com.yusufaytas.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".



Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.

Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.

Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

 */
public class BuddyStrings
{
    public boolean buddyStrings(final String A, final String B)
    {
        if (A == null || B == null || A.length() != B.length() || A.length() < 2)
        {
            return false;
        }
        int firstIndex = -1, secondIndex = -1;
        int count =0;
        final Set<Character> chars = new HashSet<>();
        for (int i = 0; i < A.length(); i++)
        {
            chars.add(A.charAt(i));
            if (A.charAt(i) != B.charAt(i))
            {
                if (firstIndex >= 0)
                {
                    secondIndex = i;
                }
                else
                {
                    firstIndex = i;
                }
                count++;
            }
        }
        if (firstIndex >= 0)
        {
            if (secondIndex > 0 && count == 2)
            {
                return A.charAt(firstIndex) == B.charAt(secondIndex)
                        && A.charAt(secondIndex) == B.charAt(firstIndex);
            }
            return false;
        }
        return chars.size() < A.length();
    }

    public static void main(String[] args)
    {
        final String A = "abab";
        final String B = "baba";
        System.out.println(new BuddyStrings().buddyStrings(A, B));
    }
}
