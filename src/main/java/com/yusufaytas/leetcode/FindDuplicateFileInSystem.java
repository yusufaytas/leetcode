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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least two files that have exactly the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:

Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

Note:

    No order is required for the final output.
    You may assume the directory name, file name and file content only has letters and digits,
    and the length of file content is in the range of [1,50].
    The number of files given is in the range of [1,20000].
    You may assume no files or directories share the same name in the same directory.
    You may assume each given directory info represents a unique directory.
    Directory path and file info are separated by a single blank space.

Follow-up beyond contest:

    Imagine you are given a real file system, how will you search files? DFS or BFS?
    If the file content is very large (GB level), how will you modify your solution?
    If you can only read the file by 1kb each time, how will you modify your solution?
    What is the time complexity of your modified solution? What is the most time-consuming part
    and memory consuming part of it? How to optimize?
    How to make sure the duplicated files you find are not false positive?

 */
public class FindDuplicateFileInSystem {

  public List<List<String>> findDuplicate(final String[] paths) {
    if (paths == null || paths.length == 0) {
      Collections.emptyList();
    }
    final Map<String, List<String>> files = new HashMap<>();
    for (int i = 0; i < paths.length; i++) {
      final String path = paths[i];
      final String[] directory = path.split("\\s");
      for (int j = 1; j < directory.length; j++) {
        final String content = directory[j]
            .substring(directory[j].indexOf("("), directory[j].length() - 1);
        final String filename = directory[j].replaceAll("\\(.+\\)", "");
        if (!files.containsKey(content)) {
          files.put(content, new ArrayList<>());
        }
        files.get(content).add(directory[0] + "/" + filename);
      }
    }
    return files.values().stream()
        .filter(strings -> strings.size() > 1)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final String[] paths = {"root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)",
        "root/c/d 4.txt(efggdfh)"};
    System.out.println(new FindDuplicateFileInSystem().findDuplicate(paths));
  }
}
