// Medium
// String, Greedy
// O(n)
// https://leetcode.com/problems/partition-labels/

import java.util.*;

class Solution {
    // 將字符串s分成盡可能多的片段，每個字母只出現在其中的一個片段裡
    // 返回一個list包含每個片段的長度
    public List<Integer> partitionLabels(String s) {
        // 紀錄每個字符最後出現的位置
        int[] last = new int[26]; // 只包含小寫字母
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // 遍歷字符串，更新當前片段的結束位置
        // 如果當前索引到了片段的結束位置，就可以分割
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(end - start + 1);
                start = i + 1; // 更新下一段的起始位置
            }
        }
        return res;
    }
}