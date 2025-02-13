// Medium
// Two Pointers
// Time:O(m+n), Space:O(m+n)
// https://leetcode.cn/problems/interval-list-intersections/

import java.util.*;
class Solution {
    // Use two pointers i and j to traverse firstList and secList
    // Find intersection [max(A[i][0], B[j][0]), min(A[i][1], B[j][1])]
    // Move the pointer with the smaller end value
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            // calculate intersection
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) res.add(new int[]{start, end});

            // move the smaller end value
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
