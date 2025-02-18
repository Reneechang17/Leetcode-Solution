// Medium
// Hash Table, Sliding Window
// Time:O(m + n), Space: O(k)
// https://leetcode.cn/problems/find-all-anagrams-in-a-string/

import java.util.*;
class Solution {
    // use sliding window to adjust the substring
    // 'need' map store the required char and their freq from string p
    // 'window' map keep track the freq of char in cur window
    // compare two map to determine if the cur window contains a valid anagram
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // update char in window
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // if the length > p.length() -> shrink the window
            while (right - left >= p.length()) {
                if (valid == need.size()) res.add(left);
                char drop = s.charAt(left);
                left++;
                // update window
                if (need.containsKey(drop)) {
                    if (window.get(drop).equals(need.get(drop))) {
                        valid--;
                    }
                    window.put(drop, window.get(drop) - 1);
                }
            }
        }
        return res;
    }
}
