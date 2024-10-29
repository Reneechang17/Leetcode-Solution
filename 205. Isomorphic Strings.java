// Easy
// Hash Table, String
// O(n)
// Similar: 290
// https://leetcode.cn/problems/isomorphic-strings/

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 檢查兩個字符串是不是同構的
        // 需要檢查字符的數量和字符之間的映射關係是否一致 -> 哈希表
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>(); // store sChar, tChar
        Map<Character, Character> tMap = new HashMap<>(); // store tChar, sChar

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
            }

            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}

/**
 * 檢查兩個字符串是不是同構的：即一個字符串中的字母可以被替換成另一個字符串中的字母，每個字符的替換都是一一對應的，而且每個字符都只能被替換成一個特定的字符，不同的字符不能映射到同一個字符上
 * 思路：basecase比較簡單，檢查兩個字符串的長度是否相同
 * 但這題不僅是檢查字符串的數量是否相等，重點在於確保字符之間的映射關係一致
 * 實現映射檢查的方法是開兩個哈希表，分別紀錄s到t和t到s的映射關係，確保任何時候的映射都是一一對應的（一致並唯一）
 **/
