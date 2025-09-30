// Medium
// Map
// Time:O(n²), Space:O(n²)
// https://leetcode.cn/problems/4sum-ii/

import java.util.*;

// Interesting. Group them and check as group is good idea hahaha:D
// original:                optimize:
// for(nums1)                  for(nums1) n time
//  for(nums2)                  for(nums2) n time
//   for(nums3)                  put in map O(1)
//    for(nums4)               for(nums3) n time
//     check if sum == 0        for(nums4) n time
//                               check in map O(1)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        // (a + b) + (c + d) = 0
        // (a + b) = -(c + d)
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }

        return res;
    }
}
