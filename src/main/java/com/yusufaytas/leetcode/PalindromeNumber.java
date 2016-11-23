package com.yusufaytas.leetcode;

public class PalindromeNumber
{
    public boolean isPalindrome(int x)
    {
        if (x < 0)
        {
            return false;
        }
        if(x == 0)
        {
            return true;
        }
        int length = 10;
        while ((int) (x / Math.pow(10, length)) == 0)
        {
            length--;
        }
        while (x != 0)
        {
            int k = (int) (x / Math.pow(10, length));
            int m = x % 10;
            if (k != m)
            {
                return false;
            }
            x = (x % (int) Math.pow(10, length)) / 10;
            length = length - 2;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(new PalindromeNumber().isPalindrome(0));
    }
}
