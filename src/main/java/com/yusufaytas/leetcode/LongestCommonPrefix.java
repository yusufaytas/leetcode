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
Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{}));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int current = 0;
    boolean stop = false;
    StringBuilder builder = new StringBuilder();
    while (!stop) {
      Character c = null;
      for (int i = 0; i < strs.length; i++) {
        if (strs[i] != null && strs[i].length() > current) {
          if (c == null) {
            c = strs[i].charAt(current);
          }
          if (c != strs[i].charAt(current)) {
            stop = true;
          }
        } else {
          stop = true;
        }
      }
      if (!stop) {
        builder.append(c);
        current++;
      }
    }
    return builder.toString();
  }
}
