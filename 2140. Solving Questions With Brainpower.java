// Medium
// DP
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/solving-questions-with-brainpower/

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int score = questions[i][0];
            int brainpower = questions[i][1];

            dp[i] = Math.max(score + (i + brainpower + 1 < n ? dp[i + brainpower + 1] : 0), dp[i + 1]);
        }
        return dp[0]; // 从第一个问题开始的最大分
    }
}

/**
 * 如果选择了一个问题，就不能再选择它后面的一些问题（取决于问题的brainpower）
 * => 这是一个选择问题，同时考虑跳过一些问题，最大化得分 => DP
 * dp[i]表示从问题i到问题n-1所能获得的最大分数：
 * 如果选择当前问题i：可以获得points[i]，但需要跳过brainpower[i]个问题，剩下的问题的最大得分是dp[i + brainpower[i]
 * + 1]
 * 如果不选择当前的问题：直接跳到问题i+1
 * 但是这题我们需要从后面向前遍历，因为我们当前问题的最优解依赖未来问题的解
 */
