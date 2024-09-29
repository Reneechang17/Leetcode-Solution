// Medium
// Sliding Window, Hash Table
// O(n)
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1);
            }
            map.put(cur, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}

/**
 * 無重複字符的最長子串：給定一個字符串s，找到最長的子串的長度，該子串中沒有重複字符
 * 
 * 思路：滑動窗口（也可以看作是兩個指針），用哈希表來記錄字符出現的位置，當遇到重複字符時，將左指針移動到重複字符的下一個位置
 * 並更新最長子串的長度
 **/