// Medium
// DP
// O(n^2k)
// https://leetcode.cn/problems/word-break/

import java.util.*;

class Solution {
    // 單詞拆分：判斷字符串s是否可以分割成一個或多個在wordDict中的單詞
    // 可以看作是一個背包問題，將單詞看作物品，字符串s看作背包，看單詞能不能組成字符串，也就是物品能不能把背包放滿
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        // dp數組表示前i個字符能不能拆分
        // dp[0]初始化為true，dp[i]是由dp[j]推出來的，如果初始化不是true，後面全是false
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                // 相當於在[0:i]中間塞一個j分割
                // 檢查[j:i]是否在set中，並確定dp[j]是true，即[0:j]是可以拆分的
                if(set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
