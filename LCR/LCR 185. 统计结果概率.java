// Medium
// DP
// Time:O(num * 6 * num), Space:O(6 * num)
// https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/

import java.util.Arrays;

class Solution {
    public double[] statisticsProbability(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        // 遍历从2个骰子到num个骰子的情况
        for (int i = 2; i <= num; i++) {
            double[] tmp = new double[5 * i + 1];
            // 遍历前一个骰子的结果dp[j]，加上当前骰子的所有可能值1~6
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
/**
 * 要求计算通过num次骰子投掷所得到的所有可能点数和的概率，可以用DP做
 * dp[j]表示投掷一定数量的骰子后，得到点数和为j的概率
 * 初始化：当只有一个骰子时，每个点数(1~6)的概率是均等的，因此dp数组初始化都为1/6
 * 递推：对于每个骰子，从前dp数组生成新的dp数组：对于每个已经存在的点数和k，通过加上一个新的骰子的结果(1~6)来更新的点数和j+k的概率
 */
