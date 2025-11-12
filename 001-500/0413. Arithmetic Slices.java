// Medium
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/arithmetic-slices/

class Solution {
    // The idea is pretty similar (or just the same) to 2348
    // Sort of just finding the consecutive cnt can contribute to res(goal)
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int res = 0, cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cnt++;
                res += cnt;
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
