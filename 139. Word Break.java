// Medium
// DP
// O(n^2k)
// https://leetcode.cn/problems/word-break/

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        // dp數字表示前i個字符能不能被拆分
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                // 檢查s[j:i]是否在字典中，以及確定dp[j]是true，即s[0:j]是可以拆分的
                // 相當於在[0:i]中間塞一個j分割
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

/**
 * 單詞拆分：判斷字符串s是否可以被分割成一個或多個在wordDict中出現的單詞
 * 這是一題背包問題，可以將單詞看作物品，字符串s看作背包，看單詞能不能組成s，就是問物品能不能把背包裝滿
 * 
 * dp數組表示字符串的前i個字符可不可以被拆分
 * dp[0]初始化為true，dp[i]由dp[j]推出來的，如果初始化不是true，後面全部都是false
 * 所以我們在確定[0:i]之前，要確定[0:j]也是可以拆分的，即dp[j]為true，並且[j:i]在字典中
 **/