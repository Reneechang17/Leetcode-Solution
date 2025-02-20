// Hard 
// Sliding Window, Hash Table
// Time:O(n*wordLen),Space:O(m)
// https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int wordLen = words[0].length(), numWord = words.length, windowSize = wordLen * numWord;

        // use Map to store the appear time of each char
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // iterate all possible start point(0~wordLen-1)
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> curCount = new HashMap<>();

            // expand right window
            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;

                // if cur word in words
                if (map.containsKey(w)) {
                    curCount.put(w, curCount.getOrDefault(w, 0) + 1);

                    // if cur word exceed the num in words -> shrink window
                    while (curCount.get(w) > map.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        curCount.put(leftWord, curCount.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // if window size == target size -> valid
                    if (right - left == windowSize) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        curCount.put(leftWord, curCount.get(leftWord) - 1);
                        left += wordLen;
                    }
                } else {
                    // if cur word not in words, clear cur window
                    curCount.clear();
                    left = right;
                }
            }
        }
        return res;
    }
}
