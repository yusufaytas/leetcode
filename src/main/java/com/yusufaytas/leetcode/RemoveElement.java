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

import static com.yusufaytas.leetcode.Utils.printArray;

public class RemoveElement {

  public static void main(String[] args) {
    final int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    System.out.println(new RemoveElement().removeElement(nums, 2));
    printArray(nums);
  }

  public int removeElement(int[] nums, int val) {
    int count = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == val) {
        count++;
        final int temp = nums[nums.length - count];
        nums[nums.length - count] = nums[i];
        nums[i] = temp;
      }
    }
    return nums.length - count;
  }
}
