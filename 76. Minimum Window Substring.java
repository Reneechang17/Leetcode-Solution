// Hard 
// Sliding Window, Hash Table, Array
// O(n)
// Similar: 438, 567
// https://leetcode.cn/problems/minimum-window-substring/

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }


        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 右指針把元素加進來
            char incoming = s.charAt(right);
            right++;

            if (tmap.containsKey(incoming)) {
                window.put(incoming, window.getOrDefault(incoming, 0) + 1);
                if (window.get(incoming).equals(tmap.get(incoming))) {
                    valid++;
                }
            }

            // 判斷左側要不要收縮
            while (valid == tmap.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char drop = s.charAt(left);
                left++;
                if (tmap.containsKey(drop)) {
                    if (window.get(drop).equals(tmap.get(drop))) {
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
 * 右指針擴展窗口，左指針收縮窗口，每次收縮窗口時更新最小子串
 * 並用哈希表need紀錄t出現的次數，window紀錄滑動窗口中每個字符出現的次數
 * 
 * 定義左右雙指針、valid紀錄窗口中滿足need條件的字符數量、start和len紀錄最小覆蓋子串的起始索引和長度
 * 遍歷s：
 * 擴大窗口：incoming（移動right）
 *  （1）如果need中有incoming，更新window的數據
 *      a.如果當前窗口的數量（window）已經達到need的數量，則valid++
 *   (2) 判斷窗口需要縮小的情況（移動left）
 *      a.更新最小覆蓋子串（start & len）
 *      b.處理要drop掉的字段，檢查drop掉的字段是否在need中
 *        如果在=> check window中字符drop的數量是否剛好等於need的數量 => if true => valid--
 *          => 更新window數據
 * 
 * Note: 擴大或縮小可能會導致subarray還滿不滿足t，因此需要更新valid
 **/
