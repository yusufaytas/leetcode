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

public class CountPrimes {

  public static void main(String[] args) {
    System.out.println(new CountPrimes().countPrimes(10));
  }

  public int countPrimes(int n) {
    int count = 0;
    boolean[] notPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      if (notPrime[i]) {
        continue;
      }
      count++;
      for (int j = 2; i * j < n; j++) {
        notPrime[i * j] = true;
      }
    }
    return count;
  }
}
