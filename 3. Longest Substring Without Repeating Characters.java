// Medium
// Sliding Window, Hash Table
// O(n)
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
            
            // if the map have cur char, means we occur the repeating char
            // so we need to move the start of window to the next of this char
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1);
            }

            // or we put the char in map and calculate the substring
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
