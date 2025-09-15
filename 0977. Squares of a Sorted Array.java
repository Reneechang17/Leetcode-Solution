// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        int[] res = new int[nums.length];
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k] = nums[j] * nums[j];
                j--;
            } else {
                res[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return res;
    }
}
