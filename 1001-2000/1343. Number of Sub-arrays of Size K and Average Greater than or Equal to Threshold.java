// Medium
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

class Solution {
    // Find all the arr length of k, their sum >= k * threshold
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int targetSum = k * threshold;
        int curSum = 0;
        // calculate the sum of first window
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }
        if (curSum >= targetSum) {
            count++;
        }
        // go through and update the window 
        for (int i = k; i < arr.length; i++) {
            curSum += arr[i] - arr[i - k];
            if (curSum >= targetSum) {
                count++;
            }
        }
        return count;
    }
}
