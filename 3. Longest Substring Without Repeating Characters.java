// Medium
// Sliding Window, Hash Table
// O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    // substring -> Sliding Window
    // Check the repeating char -> HashMap -> store the char and its index
    public int lengthOfLongestSubstring(String s) {
        // map: store the char and its index
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;

        for(int right = 0; right < s.length(); right++) {
            // check if the cur char has already in map
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                // move the left pointer to the next of the cur one
                left = Math.max(left, map.get(cur) + 1);
            }
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
