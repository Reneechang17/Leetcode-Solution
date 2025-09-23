// Medium
// Map, Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/identify-the-largest-outlier-in-an-array/

import java.util.*;

// One of my fav question hehe

class Solution {
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            totalSum += x;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int outlier = Integer.MIN_VALUE;

        // we assume each num as outlier and check
        for (int x : nums) {
            int remain = totalSum - x; // if cur x is ourlier

            // first check: if x is, the remain should be divide into two part
            // one is A special num, one is A SET OF number their sum is special num
            if (remain % 2 == 0) {
                int special = remain / 2;

                // totalSum = Special num + x(cur) + sum(remain)
                // make sure special appear in original arr
                // and it is not the same as current x, or if they are same
                // special should appear in arr more than once
                if (map.containsKey(special) && (special != x || map.get(special) > 1)) {
                    outlier = Math.max(outlier, x);
                }
            }
        }
        return outlier;
    }
}
