// Hard 
// Sliding Window, Hash Table
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/minimum-window-substring/

import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        // basecase
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        // use tMap to store the char in t and it's appear time
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // create a map to store the char and its freq in window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char next = s.charAt(right);
            right++;
            // check if next is already in tMap, and put it in window(Map)
            // and check if the next in both map are equal, if so, valid++
            if (tMap.containsKey(next)) {
                window.put(next, window.getOrDefault(next, 0) + 1);
                if (window.get(next).equals(tMap.get(next))) {
                    valid++;
                }
            }
            // when valid is equal to tMap's size
            // calculate the window's size and try to shrink the window
            while (valid == tMap.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char drop = s.charAt(left);
                left++;
                if (tMap.containsKey(drop)) {
                    if (window.get(drop).equals(tMap.get(drop))) {
                        valid--;
                    }
                    window.put(drop, window.get(drop) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

/**
* Use sliding window to find the min window in string `s`
*    that contains all chars of string `t`. The steps are:
* 1. Use Map `tMap` to store the freq of chars in `t`
* 2. Use sliding window with `left` and `right` pointers to track chars in `s`
* 3. Expand the window by moving `right` and update the freq of chars in `window`
* 4. When all chars in `t` are matched (`valid == tMap.size()`), shrink window by moving `left`
*    to find the smallest valid window
* 5. Return the smallest window substring or an empty string if no valid window is found
*/
