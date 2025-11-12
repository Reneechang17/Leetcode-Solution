// Easy
// Set
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1;

        for (int x : nums) {
            if (set.contains(-x)) {
                max = Math.max(max, Math.abs(x));
            }
            set.add(x);
        }
        return max;
    }
}
