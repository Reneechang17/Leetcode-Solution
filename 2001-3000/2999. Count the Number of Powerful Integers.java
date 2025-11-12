// Hard
// Digit DP
// Time:O(n*10),Space:O(n)
// https://leetcode.cn/problems/count-the-number-of-powerful-integers/

import java.util.Arrays;

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start), high = Long.toString(finish);
        int n = high.length();
        // 低位数字补零对齐
        low = String.format("%" + n + "s", low).replace(' ', '0');
        // 计算前缀长度：总长度-后缀长度
        int pre_len = n - s.length(); 

        // 记忆化数组
        long[] memo = new long[n];
        Arrays.fill(memo, -1);

        // 从第一位开始递归
        return dfs(0, true, true, low, high, limit, s, pre_len, memo);
    }

    private long dfs(int i, boolean limit_low, boolean limit_high, String low, String high, int limit, String s, int pre_len, long[] memo) {
        // 处理所有位置
        if (i == low.length()) {
            return 1;
        }

        // memo: 如果不受上下限制且已经计算过，直接返回
        if (!limit_low && !limit_high && memo[i] != -1) {
            return memo[i];
        }

        // 确定当前位可以用的数字范围
        int lo = limit_low ? low.charAt(i) - '0' : 0;
        int hi = limit_high ? high.charAt(i) - '0' : 9;

        long res = 0;
        if (i < pre_len) {
            // 在前缀部分：可选范围内的任何数组，不超过limit
            for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                res += dfs(i + 1, 
                           limit_low && digit == lo, 
                           limit_high && digit == hi, 
                           low, high, limit, s, pre_len, memo);
            }
        } else {
            // 在后缀部分：必须使用制定的后缀数字
            int x = s.charAt(i - pre_len) - '0';
            // 检查后缀数字是否在允许范围内
            if (lo <= x && x <= Math.min(hi, limit)) {
                res = dfs(i + 1, 
                          limit_low && x == lo, 
                          limit_high && x == hi, 
                          low, high, limit, s, pre_len, memo);
            }
            // 如果不在范围内则res=0
        }
        if (!limit_low && !limit_high) {
            memo[i] = res;
        }
        return res;
    }
}
