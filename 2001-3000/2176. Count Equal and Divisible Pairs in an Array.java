// Easy
// Iteration
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/

class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i * j) % k == 0 && nums[i] == nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
