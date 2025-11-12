// Hard 
// Sliding Window
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/minimum-window-substring/

import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        // basecase
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, cnt = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (tMap.containsKey(rightChar) && window.get(rightChar) <= tMap.get(rightChar)) {
                cnt++;
            }

            while (cnt == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && window.get(leftChar) < tMap.get(leftChar)) {
                    cnt--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
