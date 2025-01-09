// Medium
// Greedy, Divide and Conquer
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-subarray/

class Solution {
    // Iterate the array while maintain a running sum (count)
    // If the running sum becomes negative, reset to 0
    // Since every negative possible cannot form the max subarray
    public int maxSubArray(int[] nums) {
        // basecase
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if (count < 0) count = 0;
        }
        return max;
    }
}

// O(nlogn) -> Divide and Conquer
 class Solution2 {
    public int maxSubArray(int[] nums) {
        return findHelper(nums, 0, nums.length - 1);
    }

    private int findHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) >> 1;

        int leftMax = findHelper(nums, left, mid); // 左半部分的最大子數組和
        int rightMax = findHelper(nums, mid + 1, right); // 右半部分的最大子數組和
        int crossMax = maxCrossHelper(nums, left, mid, right); // 跨越中間的最大子數組和

        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    private int maxCrossHelper(int[] nums, int left, int mid, int right) {
        // 從中點向左計算最大子數組和
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // 從中點向右計算最大子數組和
        int rightSum = Integer.MIN_VALUE;
        sum = 0; 
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}
