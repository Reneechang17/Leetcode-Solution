// Easy
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1, count = 1, n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > res) {
                res = count;
            }
        }
        return res;
    }
}
