// Easy
// Iteration
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/

class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            if (String.valueOf(x).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
