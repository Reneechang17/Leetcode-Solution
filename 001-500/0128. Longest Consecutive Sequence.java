// Medium
// Set
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-consecutive-sequence/

import java.util.*;
class Solution {
    // Use a Set to remove duplicates and enable fast lookup
    // Iterate through the set, and for each number, check if it can be start 
    // If it can start, continue incrementing and checking for n+1, counting the sequence length
    // Update the max length found for each sequence
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int x : set) {
            // check start: set cannot contain the n - 1
            if (!set.contains(x - 1)) {
                int curNum = x;
                int curRes = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curRes++;
                }
                res = Math.max(res, curRes);
            }
        }
        return res;
    }
}
