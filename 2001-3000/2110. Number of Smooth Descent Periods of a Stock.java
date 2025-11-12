// Medium
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/

class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 1, cnt = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            res += cnt;
        }
        return res;
    }
}
