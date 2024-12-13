// Easy
// Hash Table
// Time:O(n), Space:O(1) 
// https://leetcode.cn/problems/roman-to-integer/

import java.util.*;

class Solution {
    // Use map to mapping the relationship between symbol and value
    // Then iterate the string, check if cur value is less then its next
    //  - if so, we need to subtract to res, otherwise add to res
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
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
