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

public class PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(new PalindromeNumber().isPalindrome(0));
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x == 0) {
      return true;
    }
    int length = 10;
    while ((int) (x / Math.pow(10, length)) == 0) {
      length--;
    }
    while (x != 0) {
      int k = (int) (x / Math.pow(10, length));
      int m = x % 10;
      if (k != m) {
        return false;
      }
      x = (x % (int) Math.pow(10, length)) / 10;
      length = length - 2;
    }
    return true;
  }
}
