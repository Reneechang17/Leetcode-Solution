// Medium
// Hash Table, Backtracking
// Time:O(2^n), Space:O(n)
// https://leetcode.cn/problems/word-pattern-ii/

import java.util.*;

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        return backtracking(pattern, s, 0, 0, map1, map2);

    }

    private boolean backtracking(String pattern, String s, int i, int j, Map<Character, String> map1,
            Map<String, Character> map2) {
        if (i == pattern.length() && j == s.length()) {
            return true;
        }
        if (i == pattern.length() || j == s.length()) {
            return false;
        }

        char c = pattern.charAt(i);

        // try possible chars
        for (int k = j + 1; k <= s.length(); k++) {
            String word = s.substring(j, k);
            if (!map1.containsKey(c) && !map2.containsKey(word)) {
                map1.put(c, word);
                map2.put(word, c);
                if (backtracking(pattern, s, i + 1, k, map1, map2)) {
                    return true;
                }
                map1.remove(c);
                map2.remove(word);
            } else if (map1.containsKey(c) && map1.get(c).equals(word) && map2.get(word) == c) {
                if (backtracking(pattern, s, i + 1, k, map1, map2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
