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
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : set) {
            // check if the n can be start: set cannot contain the n - 1
            if (!set.contains(n - 1)) {
                int curNum = n;
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
