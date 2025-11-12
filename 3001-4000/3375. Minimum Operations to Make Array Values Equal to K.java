// Easy
// Set
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        for (int x : nums) {
            if (x < k) return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x > k) {
                set.add(x);
            }
        }
        return set.size();
    }
}
