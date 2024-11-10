// Hard 
// Sliding Window, Hash Table
// O(n)
// https://leetcode.cn/problems/minimum-window-substring/

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // basecase
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";

        // use map to store the char in t and it's appear time
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // use right pointer to add the elements
            char next = s.charAt(right);
            right++;

            // check if this word is already in tMap
            // then we put it in window map, and check if the next in both map are equal
            // if so, valid++
            if (tMap.containsKey(next)) {
                window.put(next, window.getOrDefault(next, 0) + 1);
                if (window.get(next).equals(tMap.get(next))) {
                    valid++;
                }
            }

            // when the valid is equal to the tMap's size
            // and we calculate the window's size and try to shrink the window
            while (valid == tMap.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char drop = s.charAt(left);
                left++;
                if (tMap.containsKey(drop)) {
                    if (window.get(drop).equals(tMap.get(drop))) {
                        valid--;
                    }
                    window.put(drop, window.get(drop) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

/**
 * 最小覆蓋子串：給定一個字符串s和一個字符串t，在s中找到包含t所有字符的最小子串
 * 
 * 思路：哈希表+滑動窗口，雙指針維護窗口邊界，尋找滿足條件的最小子串
 * 定義左右雙指針、valid紀錄窗口中滿足tMap條件的字符數量、start和len紀錄最小覆蓋子串的起始索引和長度
 * 遍歷s：
 * 擴大窗口：incoming（移動right）
 *  （1）如果need中有incoming，更新window的數據
 *      a.如果當前窗口的數量（window）已經達到need的數量，則valid++
 *   (2) 判斷窗口需要縮小的情況（移動left）
 *      a.更新最小覆蓋子串（start & len）
 *      b.處理要drop掉的字段，檢查drop掉的字段是否在need中
 *        如果在=> check window中字符drop的數量是否剛好等於need的數量 => if true => valid--
 *          => 更新window數據
 * Note: 擴大或縮小可能會導致subarray還滿不滿足t，因此需要更新valid
 **/
