import java.util.HashMap;
import java.util.Map;

// Hard 
// Sliding Window, Hash Table, Array
// O(n)
// Similar: 438, 567
// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char incoming = s.charAt(right);
            right++;

            if (need.containsKey(incoming)) {
                window.put(incoming, window.getOrDefault(incoming, 0) + 1);
                if (window.get(incoming).equals(need.get(incoming))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char drop = s.charAt(left);
                left++;
                if (need.containsKey(drop)) {
                    if (window.get(drop).equals(need.get(drop))) {
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
 * 思路：哈希表+滑動窗口
 * base case: 返回空字符串的情況
 * 
 * 定義兩個哈希表：need紀錄t出現的次數，window紀錄滑動窗口中每個字符出現的次數
 * 
 * 先用增強for遍歷t（t用toCharArray處理一下），紀錄每個字符出現的次數
 * 
 * 定義左右雙指針、valid紀錄窗口中滿足need條件的字符數量、start和len紀錄最小覆蓋子串的起始索引和長度
 * 
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