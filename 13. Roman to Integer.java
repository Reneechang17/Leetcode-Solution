// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/roman-to-integer/

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        // 創建map
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));

            // 判斷是否需要做減法: 如果當前的值小於它後面的字符值 ex IV = 4, IX = 9
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
