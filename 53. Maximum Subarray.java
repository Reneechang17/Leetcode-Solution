// Medium
// Greedy, Divide and Conquer
// O(n) -> Greedy, O(n logn) -> Divide and Conquer
// https://leetcode.cn/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            maxSum = Math.max(maxSum, count);
            // 如果count加上當前的值已經小於等於0的話直接讓count歸零
            // 任何包含負總和的都不能構建出最大子序和
            // 但是可以包含負數，只是不想有負數和
            if (count <= 0) {
                count = 0;
            }
        }
        return maxSum;
    }
}

/**
 * 最大子序和，至少包含一個數字
 * 
 * 在遍歷nums數組時，從頭開始用count累積，並用一個變量sum來不斷更新最大子序和，一旦count加上nums[i]為負數，那就從nums[i+1]開始重新count（count從0開始）
 * 不用擔心會錯過最大值，因為sum一直在紀錄最大值
 * 
 * 為什麼要重置count？
 * 任何包含負總和的子數組都不會是最大總和子數組的一部分
 * 當發現累積和變為0或是負數時，就從下一個元素開始重新計算，尋找新的可能的最大子數組和
 **/


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