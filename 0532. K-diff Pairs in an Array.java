// Medium
// HashSet
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/k-diff-pairs-in-an-array/

import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num - k)) {
                res.add(num - k); // store the smaller one to avoid dup
            }
            if (numSet.contains(num + k)) {
                res.add(num); // store the smaller one to avoid dup
            }
            numSet.add(num);
        }
        return res.size();
    }
}
