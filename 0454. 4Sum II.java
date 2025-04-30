// Medium
// Hash Table
// Time:O(n²),Space:O(n²)
// https://leetcode.cn/problems/4sum-ii/

import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // put nums1 and nums2 as a group, and nums3 and nums4 as a group
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // the sum should be 0, so need to find -(i+j) in other group
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
