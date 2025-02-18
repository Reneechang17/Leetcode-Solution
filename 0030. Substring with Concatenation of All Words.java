// Hard 
// Sliding Window, Hash Table
// O(m + n)
// https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || s.length() == 0 || words.length == 0) return res;
        int wordLen = words[0].length(); // 每個字的長度，直接選第一個，因為每個word的長度是一樣的
        int numWords = words.length; // word的數量
        int windowSize = wordLen * numWords; // 窗口的大小就是每個字的長度 * word的數量

        // 用哈希表計算每個word出現的次數
        Map<String, Integer> wordCnt = new HashMap<>();
        for(String word : words){
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }

        // 建立滑動窗口，設置左右邊界 & 紀錄當前的哈希表
        // 可以從s的任何位置開始，如果單詞的長度是wordLen時，理論上在s中的i(i < wordLen)都可能是一個有效序列的開始
        for(int i = 0; i < wordLen; i++){
            int left = i, right = i;
            Map<String, Integer> curCnt = new HashMap<>();

            while(right + wordLen <= s.length()){
                // 處理擴張窗口(move right)
                String w = s.substring(right, right + wordLen);
                right += wordLen;

                // 處理窗口數據
                if(wordCnt.containsKey(w)){
                    curCnt.put(w, curCnt.getOrDefault(w, 0) + 1);

                    // 處理收縮窗口的情況
                    while(curCnt.get(w) > wordCnt.get(w)){
                        String leftWord = s.substring(left, left + wordLen);
                        curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // 處理要收集的res
                    if(right - left == windowSize){
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                        left += wordLen;
                    }
                } else {
                    // 如果沒有這個字段，則curCnt清空，left移動到right的位置
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
 * 
 * 滑動窗口，先設置左右邊界 & 紀錄當前的哈希表
 * Note: 如果單詞的長度為wordLen，理論上從s中的i(i < wordLen)都可能是有效序列的開始
 * 
 * 當right+wordLen <= s的長度時，用哈希表curCnt紀錄當前
 * right移動：擴張窗口
 *（1）如果wordCnt哈希表有這個字段
 =>處理擴張窗口:將字段w加入curCnt
 * a. 處理窗口數據
 * (a) 當curCnt.get(w) > wordCnt.get(w), 處理收縮窗口的情況
 * (b) 如果right - left == windowSize：處理要收集的res
 * 
 * (2) 如果沒有這個字段，則curCnt清空，left移動到right的位置
 **/
