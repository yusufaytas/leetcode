package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
You have k lists of sorted integers in ascending order.
Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24, 26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>.
And after you reset the code template, you'll see this point.
 */
public class SmallestRange
{
    public int[] smallestRange(List<List<Integer>> nums)
    {
        if (nums.size() == 0 || nums.stream().anyMatch(l -> l.isEmpty()))
        {
            return null;
        }
        int currentMinRange = Integer.MAX_VALUE;
        int min = 0, max = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            for (int j = 0; j < nums.get(i).size(); j++)
            {
                for (int k = i; k < nums.size(); k++)
                {
                    for (int l = 0; l < nums.get(k).size(); l++)
                    {
                        int m = nums.get(i).get(j) > nums.get(k).get(l) ? nums.get(i).get(j) : nums.get(k).get(l);
                        int n = nums.get(i).get(j) < nums.get(k).get(l) ? nums.get(i).get(j) : nums.get(k).get(l);

                        int range = m - n;
                        if (range >= currentMinRange)
                        {
                            continue;
                        }

                        boolean found = true;
                        for (int a = 0; a < nums.size(); a++)
                        {
                            boolean isFoundInList = false;
                            for (int b = 0; b < nums.get(a).size(); b++)
                            {
                                int val = nums.get(a).get(b);
                                if (val <= m && val >= n)
                                {
                                    isFoundInList = true;
                                    break;
                                }
                            }
                            found = found && isFoundInList;
                        }
                        if (found)
                        {
                            currentMinRange = range;
                            min = m;
                            max = n;
                        }
                    }
                }
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args)
    {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1,1, 2, 3);
        List<Integer> l2 = new ArrayList<>();
        Collections.addAll(l2,1, 2, 3);
        List<Integer> l3 = new ArrayList<>();
        Collections.addAll(l3,1, 2, 3);
        Collections.addAll(nums, l1, l2, l3);
        System.out.println(new SmallestRange().smallestRange(nums));
    }
}
