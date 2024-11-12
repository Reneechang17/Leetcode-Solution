// Medium
// Hash Table
// O(n)
// https://leetcode.cn/problems/longest-consecutive-sequence/

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        // use set to filter the duplicate number
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

                // then we can keep tracking if there have n + 1
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
