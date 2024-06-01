// Hard 
// Sliding Window, Hash Table, Array
// O(n)
// Similar: 438, 567

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // handle the situation that return the blank string("")
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        // define two hash table
        // use 'need' to record the times that 't' appear
        // use 'window' to record the times that each string appear
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // first handle 't'
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // define two pointers
        int left = 0, right = 0;
        // use 'valid' to record the number of string meet the condition in 'need'
        int valid = 0;
        // 'start' and 'len' record the start index and length ofminimunm covered string
        int start = 0, len = Integer.MAX_VALUE;

        // iterate the 's'
        while (right < s.length()) {
            // 'incoming' is the incoming string which will moving to window
            char incoming = s.charAt(right);
            right++;

            // update the value in window
            if (need.containsKey(incoming)) {
                window.put(incoming, window.getOrDefault(incoming, 0) + 1);
                // if 'window.get(incoming)' equal to need.get(incoming), then valid++
                if (window.get(incoming).equals(need.get(incoming))) {
                    valid++;
                }
            }
            // check if the left side of the window should be shrink
            while (valid == need.size()) {
                // update
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
