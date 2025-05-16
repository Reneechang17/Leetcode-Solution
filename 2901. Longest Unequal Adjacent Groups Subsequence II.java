// Medium
// DP
// Time:O(n² * L),Space:O(n)
// https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/

import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n]; // 索引i结尾的最长有效子序列长度
        int[] prev = new int[n]; // 索引i结尾的最长有效子序列中，i之前的索引

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1, endIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == groups[j]) continue;
                if (!checkHammingDis(words[i], words[j])) continue;

                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;

                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        while (endIndex != -1) {
            res.add(0, words[endIndex]); // add from tail to start
            endIndex = prev[endIndex];
        }
        return res;
    }

    private boolean checkHammingDis(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
