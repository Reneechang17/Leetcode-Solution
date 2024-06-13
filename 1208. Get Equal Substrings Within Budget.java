// Medium
// String, Sliding Window, Two Pointers
// O(n)
// https://leetcode.com/problems/get-equal-substrings-within-budget/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int sum = 0, ans = 0;
        for (int i = 0, j = 0; i < len; ++i) {
            sum += Math.abs(s.charAt(i) - t.charAt(i));
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(j) - t.charAt(j));
                ++j;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

/**
 * 思路：用雙指針控制滑動窗口
 * 不斷更新sum，當sum超出最大cost的時候，移動j指針，縮小窗口並且更新sum
 **/