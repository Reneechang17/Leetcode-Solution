// Medium
// Sliding Window
// O(n)
// https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // 這題相當於在找所有長度為k的子數組，其和大於等於k * threshold
        // -> 滑動窗口
        int count = 0;
        int targetSum = k * threshold;
        int curSum = 0;

        // 先計算第一個窗口的和
        for (int i  = 0; i < k; i++) {
            curSum += arr[i];
        }

        if (curSum >= targetSum) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            curSum += arr[i] - arr[i - k]; // 加上新的值，減去出去的值
            if (curSum >= targetSum) {
                count++;
            }
        }
        return count;
    }
}
