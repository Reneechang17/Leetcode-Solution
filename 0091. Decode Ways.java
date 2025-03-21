// Medium
// DP
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s == null) return 0;
        int n = s.length();
        int[] dp = new int[n + 1]; // 前i个数字的解码方式

        dp[0] = 1; // 空字符串
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // 如果不是0，就只有一种解码方式

        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            char pre = s.charAt(i - 2);

            if (cur != '0') {
                dp[i] += dp[i - 1];
            }
            
            // 如果当前两位数在10～26，可以看作一个两位数
            if (pre == '1' || (pre == '2' && cur <= '6')) {
                dp[i] += dp[i - 2];
            } 
        }
        return dp[n];
    }
}
