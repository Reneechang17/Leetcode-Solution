// Medium
// Sliding Window, Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    // find substring -> sliding window, check repeating -> HashMap
    public int lengthOfLongestSubstring(String s) {
        // use HashMap to store the cur char and its index
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            // if map have cur char, means occur the repeating char
            // then move the start of window to the next of this char
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1);
            }
            // or put the char in map and calculate the substring
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
