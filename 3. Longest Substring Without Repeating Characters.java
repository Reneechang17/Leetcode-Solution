// Medium
// Sliding Window, Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    // find substring -> sliding window, check repeating -> HashMap
    public int lengthOfLongestSubstring(String s) {
        // use HashMap to store the char and its index
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;

        // iterate the string
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);

            // left pointer moves forward whenever a repeating character is found
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1);
            }
            // or put the char in map and update the substring
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
