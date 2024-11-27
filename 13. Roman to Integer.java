// Easy
// Hash Table
// Time:O(n), Space:O(1) only 7 roman numerals
// https://leetcode.cn/problems/roman-to-integer/

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            // Check if the cur value is less than its next value -> subtraction
            if (i < s.length() - 1 && val < map.get(s.charAt(i + 1))) {
                res -= val;
            } else {
                res += val;
            }
        }
        return res;
    }
}
