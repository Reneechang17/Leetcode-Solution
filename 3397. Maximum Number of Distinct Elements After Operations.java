// Medium
// Sorting, Array
// Time:O(nlogn), Space: O(1)
// https://leetcode.cn/problems/maximum-number-of-distinct-elements-after-operations/

// We can just iteration to find the smallest postion for next available.
// So that we can get the max diff number after ops.

import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0, nextAvailable = Integer.MIN_VALUE;
        
        for (int x : nums) {
            int minPos = x - k, maxPos = x + k;
            if (nextAvailable <= maxPos) {
                nextAvailable = Math.max(nextAvailable, minPos);
                cnt++;
                nextAvailable++;
            }
        }
        return cnt;
    }
}
