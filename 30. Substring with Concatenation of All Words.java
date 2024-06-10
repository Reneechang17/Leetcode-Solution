import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hard 
// Sliding Window, Hash Table
// O(m + n)
// Similar: 438, 567
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0)
            return res;
        int wordLen = words[0].length(); // the length of each word
        int numWords = words.length; // how many words
        int windowSize = wordLen * numWords; // windowSize = wordLen * numWords
        // set hash table for words
        Map<String, Integer> wordCnt = new HashMap<>();
        for (String word : words) {
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }
        // Sliding window
        // Notes: can start anywhere in s
        // If the length of the word is wordLen, i(i < wordLen) in s could be the start
        // of a valid sequence.
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> curCnt = new HashMap<>();
            while (right + wordLen <= s.length()) {
                // handle expand the window(move right)
                String w = s.substring(right, right + wordLen);
                right += wordLen;
                // update window
                if (wordCnt.containsKey(w)) {
                    curCnt.put(w, curCnt.getOrDefault(w, 0) + 1);
                    // shrink the window
                    while (curCnt.get(w) > wordCnt.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                        left += wordLen;
                    }
                    // collect the valid res
                    if (right - left == windowSize) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                        left += wordLen;
                    }
                } else {
                    curCnt.clear();
                    left = right;
                }
            }
        }
        return res;
    }
}

/**
 * 思路：哈希表+滑動窗口
 * Note: 處理的是一個word，而不是單純一個character
 * => 先用wordLen算單個word的長度
 * => 然後計算words數組有多少word
 * => 滑動窗口的大小為：每個字的長度 * word的數量
 * 
 * 1. 先建立words數組的哈希表：增強for遍歷數組，統計每個word出現的次數
 * 2. 操作滑動窗口，先設置左右邊界 &
 * Note: 如果單詞的長度為wordLen，理論上從s中的i(i < wordLen)都可能是有效序列的開始
 * 3. 當right+wordLen <= s的長度時，用哈希表curCnt紀錄當前
 * right移動：擴張窗口
 *（1）如果wordCnt哈希表有這個字段
 
 * =>處理擴張窗口:將字段w加入curCnt
 * a. 處理窗口數據
 * (a) 當curCnt.get(w) > wordCnt.get(w), 處理收縮窗口的情況
 * (b) 如果right - left == windowSize：處理要收集的res
 * 
 * (2) 如果沒有這個字段，則curCnt清空，left移動到right的位置
 **/