// Medium
// Two Pointers, Hash Table
// O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    // substring -> Two Pointers
    // check repeating -> HashMap
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // char, its idx
        int res = 0, left = 0;

        // 用right指針來向右擴張substring
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1); // 左指針易到重複元素的下一個
            }
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
