/**
 * Copyright © 2021 Yusuf Aytas. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
  }

  public boolean isPalindrome(final String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    final String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    for (int i = 0; i < clean.length() / 2; i++) {
      if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
