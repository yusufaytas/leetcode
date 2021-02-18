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
import java.util.HashSet;
import java.util.Set;

/*
A frog is crossing a river. The river is divided into some number of units,
and at each unit, there may or may not exist a stone. The frog can jump on a stone,
but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order,
determine if the frog can cross the river by landing on the last stone.
Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
The frog can only jump in the forward direction.

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone,
then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone,
4 units to the 7th stone, and 5 units to the 8th stone.

Example 2:

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone
as the gap between the 5th and 6th stone is too large.

 */
public class FrogJump {

  public boolean canCross(final int[] stones) {
    final Set<Integer>[] jumps = new Set[stones.length];
    for (int i = 1; i < stones.length; i++) {
      jumps[i] = new HashSet<>();
    }
    if (jumps.length > 1) {
      if (stones[1] != 1) {
        return false;
      }
      jumps[1].add(1);
    }
    for (int i = 1; i < stones.length; i++) {
      for (final int k : jumps[i]) {
        addJump(stones, jumps, i, k);
        addJump(stones, jumps, i, k - 1);
        addJump(stones, jumps, i, k + 1);
      }
    }
    return !jumps[stones.length - 1].isEmpty();
  }

  private void addJump(final int[] stones, final Set<Integer>[] jumps,
      final int index, final int k) {
    final int kthJumpIndex = Arrays.binarySearch(stones, stones[index] + k);
    if (kthJumpIndex >= 0 && kthJumpIndex != index) {
      jumps[kthJumpIndex].add(k);
    }
  }

  public static void main(String[] args) {
    final int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
    System.out.println(new FrogJump().canCross(stones));
  }
}
