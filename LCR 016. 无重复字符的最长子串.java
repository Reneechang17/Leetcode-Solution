// Medium
// Sliding Window, HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/wtcaE1/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();

        int len = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            len++;
            while (map.get(c) > 1) {
                len--;
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
