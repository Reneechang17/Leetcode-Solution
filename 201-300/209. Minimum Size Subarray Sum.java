// Medium
// Sliding Window, Two Pointers
// O(n)
// https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;

        int res = Integer.MAX_VALUE;
        // use j pointer to iterate the array and use to add the element
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // when the sum in sliding window bigger than target
            // we have to shrink the window by moving the i pointer
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// Also can use prefix sum method

/**
 * 思路：雙指針
 * ij指針都從0開始，用j來遍歷數組添加元素，擴大窗口，同時紀錄sum
 * 當sum大於target時，移動i指針來縮小窗口，更新最小res以及sum
 * Note: res記得初始化
 **/