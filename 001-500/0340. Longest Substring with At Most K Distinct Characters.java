// Medium
// Sliding Window, Hash Table
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/

import java.util.*;
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            // update map
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // check the case to shrink window size
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                
                // need to remove the char with 0 time appear
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
