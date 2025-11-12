// Easy
// Greedy
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-i/

import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Greedy
        List<String> res = new ArrayList<>();
        int n = groups.length;
        if (n == 0) return res;

        res.add(words[0]);
        int prev = groups[0];

        for (int i = 1; i < n; i++) {
            if (groups[i] != prev) {
                res.add(words[i]);
                prev = groups[i];
            }
        }
        return res;
    }
}
