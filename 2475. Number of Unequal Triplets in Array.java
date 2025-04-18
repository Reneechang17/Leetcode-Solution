// Easy
// Brute Force
// Time:O(n^3), Space:O(1)
// https://leetcode.cn/problems/number-of-unequal-triplets-in-array/

class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
