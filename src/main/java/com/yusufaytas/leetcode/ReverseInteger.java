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
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {

  public int reverse(int x) {
    StringBuilder builder = new StringBuilder(Long.toString(x).replace("-", ""));
    long number = Long.parseLong(builder.reverse().toString());
    number = x < 0 ? -number : number;
    if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) number;
  }
}
