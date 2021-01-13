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

public class IntegerBreak {

  public int integerBreak(final int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    final int[] products = new int[n + 1];
    products[1] = 1;
    products[2] = 2;
    products[3] = 3;
    for (int i = 4; i <= n; i++) {
      products[i] = Math.max(products[i - 2] * 2, products[i - 3] * 3);
    }
    return products[n];
  }

  public static void main(String[] args) {
    System.out.println(new IntegerBreak().integerBreak(11));
  }
}
