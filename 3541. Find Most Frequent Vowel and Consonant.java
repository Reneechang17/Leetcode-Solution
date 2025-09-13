// Easy
// Map
// Time:O(n), Space:O(c)
// https://leetcode.cn/problems/find-most-frequent-vowel-and-consonant/

import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        // we need to calculate the appear time
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int vowel = 0, cons = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (isVowel(c)) {
                vowel = Math.max(vowel, map.getOrDefault(c, 0));
            } else {
                cons = Math.max(cons, map.getOrDefault(c, 0));
            }
        }
        return vowel + cons;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
