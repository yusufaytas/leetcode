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

import java.util.HashSet;
import java.util.Set;

/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

  public boolean isMatch(String s, String p, Set<Pair> noMatches) {
    if (s == null || s.length() == 0) {
      return p == null || p.length() == 0 || p.matches("\\**");
    }
    if (s.equals(p)) {
      return true;
    }
    if (s.contains(p) || (p.contains(s) && p.replaceAll("\\*", "").length() > s.length())) {
      return false;
    }
    if (p.length() == 0) {
      return false;
    }
    if (noMatches.contains(new Pair(s, p))) {
      return false;
    }
    char cs = s.charAt(0);
    if (p.charAt(0) == '*') {
      boolean result = isMatch(s.substring(1), p.substring(1), noMatches) ||
          isMatch(s.substring(1), p, noMatches) ||
          isMatch(s, p.substring(1), noMatches);
      if (!result) {
        noMatches.add(new Pair(s, p));
      }
      return result;
    }
    if (cs == p.charAt(0) || p.charAt(0) == '?') {
      boolean result = isMatch(s.substring(1), p.substring(1), noMatches);
      if (!result) {
        noMatches.add(new Pair(s, p));
      }
      return result;
    }
    noMatches.add(new Pair(s, p));
    return false;
  }

  public boolean isMatch(String s, String p) {
    p = p.replaceAll("\\*{2,}", "*");
    return isMatch(s, p, new HashSet<Pair>(p.length()));
  }

  class Pair {

    String s;
    String p;

    public Pair(String s, String p) {
      this.s = s;
      this.p = p;
    }

    @Override
    public boolean equals(Object o) {
      Pair pair = (Pair) o;
      return p.equals(pair.p);
    }

    @Override
    public int hashCode() {
      return 31 * s.hashCode() + p.hashCode();
    }
  }
}
