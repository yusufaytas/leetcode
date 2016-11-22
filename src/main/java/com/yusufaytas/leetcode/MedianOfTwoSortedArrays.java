package com.yusufaytas.leetcode;

/*
{{REVISIT}}
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if ((nums1.length + nums2.length) % 2 == 0)
        {
            return (findKth(nums1, nums2, (nums1.length + nums2.length) / 2 - 1) +
                    findKth(nums1, nums2, (nums1.length + nums2.length) / 2)) / 2.0;
        }
        return findKth(nums1, nums2, (nums1.length + nums2.length) / 2);
    }

    public int findKth(int[] nums1, int[] nums2, int k)
    {
        return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
    }

    public int findKth(int a[], int aStart, int aEnd, int b[], int bStart, int bEnd, int k)
    {
        int aLength = aEnd - aStart + 1;
        int bLength = bEnd - bStart + 1;

        if (aLength == 0)
        {
            return b[bStart + k];
        }
        if (bLength == 0)
        {
            return a[aStart + k];
        }
        if (k == 0)
        {
            return Math.min(a[aStart], b[bStart]);
        }

        int i = k / 2;
        int j = k - i - 1;

        int aMid = Math.min(aStart + i, aEnd);
        int bMid = Math.min(bStart + j, bEnd);

        if (a[aMid] > b[bMid])
        {
            k -= (bMid - bStart + 1);
            bStart = bMid + 1;
            aEnd = aMid;
        }
        else
        {
            k -= (aMid - aStart + 1);
            aStart = aMid + 1;
            bEnd = bMid;
        }

        return findKth(a, aStart, aEnd, b, bStart, bEnd, k);
    }

}
