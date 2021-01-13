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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {

  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    Matcher matcher = Pattern.compile("\\d+").matcher(str);
    if (!matcher.find()) {
      return 0;
    }
    String cleanStr = matcher.group();
    if (cleanStr.length() == 0) {
      return 0;
    }
    if (cleanStr.length() > 11) {
      if (str.contains("-")) {
        return Integer.MIN_VALUE;
      }
      return Integer.MAX_VALUE;
    }
    if (str.contains("-") && str.contains("+")) {
      return 0;

    }
    long number = Long.parseLong(cleanStr);
    if (str.contains("-")) {
      number = -number;
    }

    if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
      if (str.contains("-")) {
        return Integer.MIN_VALUE;
      }
      return Integer.MAX_VALUE;
    }
    return (int) number;
  }
}
