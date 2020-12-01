package com.yusufaytas.leetcode;

/*
This isn't complete but it's close.

Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 */
public class FindClosestPalindrome {

  public static void main(String[] args) {
    String n = "88";
    System.out.println(new FindClosestPalindrome().nearestPalindromic(n));
  }

  public String nearestPalindromic(String n) {
    if (n == null || n.equals("")) {
      return "";
    }

    String left = "", right = "", middle = "";
    left = n.substring(0, n.length() / 2);
    if (n.length() % 2 == 0) {
      right = n.substring(n.length() / 2, n.length());
    } else {
      right = n.substring(n.length() / 2 + 1, n.length());
      middle = n.substring(n.length() / 2, n.length() / 2 + 1);
      if (left.equals("")) {
        if (middle.charAt(0) != '0') {
          middle = "" + (char) (middle.charAt(0) - 1);
        } else {
          middle = "0";
        }
      }
    }

    StringBuilder firstBuilder = new StringBuilder(left.length());
    StringBuilder secondBuilder = new StringBuilder(left.length());

    for (int i = 0, j = left.length() - 1; i < left.length(); i++, j--) {
      char l = left.charAt(i);
      char r = right.charAt(j);

      if (l < r) {
        firstBuilder.append(r);
        secondBuilder.append(l);
      } else {
        firstBuilder.append(r);
        secondBuilder.append(l);
      }
    }

    String first = firstBuilder.toString() + middle + firstBuilder.reverse().toString();
    String second = secondBuilder.toString() + middle + secondBuilder.reverse().toString();

    if (Math.abs(Long.parseLong(n) - Long.parseLong(first)) > Math
        .abs(Long.parseLong(n) - Long.parseLong(second))) {
      return second;
    }
    return first;
  }
}
