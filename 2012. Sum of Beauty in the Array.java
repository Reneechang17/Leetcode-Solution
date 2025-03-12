// Medium
// DP
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/sum-of-beauty-in-the-array/

class Solution {
    public int sumOfBeauties(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        int max = nums[0], min = nums[nums.length - 1], sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > max) {
                flag[i] = true;
            }
            max = Math.max(max, nums[i]);
        }
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] >= min) {
                flag[i] = false; // violet case1
            }
            min = Math.min(min, nums[i]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (flag[i]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }
        return sum;
    }
}
