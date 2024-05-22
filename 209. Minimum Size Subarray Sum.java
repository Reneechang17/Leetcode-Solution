// Medium
// Array, Sliding Window
// O(n)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // define the two pointers
        int i = 0;
        int sum = 0;
        // define a res array
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