// Medium
// Hash Table, Sliding Window
// Time:O(m + n), Space: O(k)
// https://leetcode.cn/problems/find-all-anagrams-in-a-string/

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            // expand window
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if (right - left >= p.length()) {
                if (valid == need.size())
                    res.add(left);
                char drop = s.charAt(left);
                left++;
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
