// Medium
// Sliding Window, Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;
class Solution {
    // Use Sliding Window to find substring, and use HashMap to check repeating char
    // Every time expand the window, check if the cur exist already
    // If existing, move the left pointer to find the next window
    public int lengthOfLongestSubstring(String s) {
        // use map to store each char and its index
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                // ensure left moves forward to exclude the last occurrence 
                // of the repeating character without ever moving backward
                left = Math.max(left, map.get(cur) + 1);
            }
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
