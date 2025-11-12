// Medium
// DP
// Time:O(n^2), Space:O(n+m)
// https://leetcode.cn/problems/word-break/

import java.util.*;

class Solution {
    // Use DP to determine if `s` can be segmented into words from `wordDict`
    // Treat it as a knapsack problem where `s` is the bag and words are items
    // dp[i] represents if the first `i` characters of `s` can be segmented
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                // we add a j into [0:i]
                // check if [j:i] in set, and if sure dp[j] is true
                // so that [0:j] can be segmented
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
