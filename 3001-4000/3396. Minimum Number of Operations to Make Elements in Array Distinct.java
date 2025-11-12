// Easy
// Simulation
// Time:O(n²),Space:O(n)
// https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        // try different ops times
        for (int ops = 0; ops <= (n + 2) / 3; ops++) {
            // calculate the start pos of remaining arr
            int start = Math.min(ops * 3, n);

            if (start == n) return ops;

            Set<Integer> set = new HashSet<>();
            boolean hasDup = false;
            for (int i = start; i < n; i++) {
                if (!set.add(nums[i])) {
                    hasDup = true;
                    break;
                }
            }
            if (!hasDup) return ops;
        }
        return (n + 2) / 3; // if all fail
    }
}
