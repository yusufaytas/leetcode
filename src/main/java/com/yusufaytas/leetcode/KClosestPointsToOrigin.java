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
import java.util.Comparator;

public class KClosestPointsToOrigin {

  public int[][] kClosest(final int[][] points, final int K) {
    Arrays.sort(points, Comparator.comparingDouble(o -> -Math.pow(o[0], 2) + Math.pow(o[1], 2)));
    return Arrays.copyOf(points,  K);
  }
}
