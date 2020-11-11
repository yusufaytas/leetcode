package com.yusufaytas.leetcode;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

 */
public class ValidPalindrome
{
    public boolean isPalindrome(final String s)
    {
        if (s == null || s.length() == 0)
        {
            return true;
        }
        final String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < clean.length() / 2; i++)
        {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String [] args)
    {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
