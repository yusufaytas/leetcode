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

import java.util.HashMap;
import java.util.Map;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    return isMatch(s, p, new HashMap<Tuple, Boolean>());
  }

  public boolean isMatch(String s, String p, Map<Tuple, Boolean> isMatches) {
    if (isMatches.containsKey(new Tuple(s, p))) {
      return isMatches.get(new Tuple(s, p));
    }
    if (s.equals("") && p.equals("")) {
      return true;
    }
    if (!s.equals("") && p.equals("")) {
      return false;
    }

    char matcher = p.charAt(0);
    boolean multiple = false;
    if (p.length() > 1) {
      multiple = p.charAt(1) == '*';
    }

    if (s.length() > 0 && (s.charAt(0) == matcher || matcher == '.')) {
      if (multiple) {
        boolean result = isMatch(s.substring(1), p, isMatches)
            || isMatch(s.substring(1), p.substring(2), isMatches)
            || isMatch(s, p.substring(2), isMatches);
        isMatches.put(new Tuple(s, p), result);
        return result;
      }
      return isMatch(s.substring(1), p.substring(1));
    } else if (multiple) {
      return isMatch(s, p.substring(2));
    }
    return false;
  }

  private class Tuple {

    private String s;
    private String p;

    private Tuple(String s, String p) {
      this.s = s;
      this.p = p;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Tuple)) {
        return false;
      }

      Tuple tuple = (Tuple) o;

      if (s != null ? !s.equals(tuple.s) : tuple.s != null) {
        return false;
      }
      return p != null ? p.equals(tuple.p) : tuple.p == null;

    }

    @Override
    public int hashCode() {
      int result = s != null ? s.hashCode() : 0;
      result = 31 * result + (p != null ? p.hashCode() : 0);
      return result;
    }
  }

}
