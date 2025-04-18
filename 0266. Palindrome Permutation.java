// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/palindrome-permutation/

import java.util.*;

class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int cnt : map.values()) {
            if (cnt % 2 != 0) {
                odd++;
            }
            if (odd > 1) return false;
        }
        return true;
    }
}
