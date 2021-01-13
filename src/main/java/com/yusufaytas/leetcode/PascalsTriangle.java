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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

  public List<List<Integer>> generate(final int numRows) {
    final List<List<Integer>> rows = new ArrayList<>();
    if (numRows == 0) {
      return rows;
    }
    rows.add(Arrays.asList(1));
    if (numRows == 1) {
      return rows;
    }
    rows.add(Arrays.asList(1, 1));
    for (int i = 2; i < numRows; i++) {
      final List<Integer> row = new ArrayList<>(i + 1);
      row.add(1);
      final List<Integer> lastRow = rows.get(rows.size() - 1);
      for (int j = 0; j < lastRow.size() - 1; j++) {
        row.add(lastRow.get(j) + lastRow.get(j + 1));
      }
      row.add(1);
      rows.add(row);
    }
    return rows;
  }
}
