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

import java.util.Arrays;

/*
Winter is coming! During the contest, your first job is to design a standard heater
with a fixed warm radius to warm all the houses.

Every house can be warmed, as long as the house is within the heater's warm radius range.
Given the positions of houses and heaters on a horizontal line, return the minimum radius
standard of heaters so that those heaters could cover all houses.

Notice that all the heaters follow your radius standard, and the warm radius will the same.

Example 1:

Input: houses = [1,2,3], heaters = [2]
Output: 1
Explanation: The only heater was placed in the position 2,
and if we use the radius 1 standard, then all the houses can be warmed.

Example 2:

Input: houses = [1,2,3,4], heaters = [1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4.
We need to use radius 1 standard, then all the houses can be warmed.

Example 3:

Input: houses = [1,5], heaters = [2]
Output: 3


 */
public class Heaters {

  public int findRadius(final int[] houses, final int[] heaters) {
    if (houses == null || heaters == null || houses.length == 0 || heaters.length == 0) {
      return 0;
    }
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int max = 0;
    for (int i = 0; i < houses.length; i++) {
      int heaterIndex = Arrays.binarySearch(heaters, houses[i]);
      if (heaterIndex >= 0) {
        continue;
      }
      heaterIndex = Math.min(Math.abs(heaterIndex + 1), heaters.length - 1);
      int closest = Math.abs(houses[i] - heaters[heaterIndex]);
      if (heaterIndex > 0) {
        closest = Math.min(closest, Math.abs(houses[i] - heaters[heaterIndex - 1]));
      }
      if (heaterIndex < heaters.length - 1) {
        closest = Math.min(closest, Math.abs(houses[i] - heaters[heaterIndex + 1]));
      }
      max = Math.max(closest, max);
    }
    return max;
  }

  public static void main(String[] args) {
    final int[] houses = {1, 2, 3, 4};
    final int[] heaters = {1, 4};
    System.out.println(new Heaters().findRadius(houses, heaters));
  }
}
