// Medium
// DP
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-ii/

import java.util.*;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int pre = 0, cur = 1;
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (i < n && nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                res = Math.max(res, cur / 2);
                res = Math.max(res, Math.min(pre, cur));
                pre = cur;
                cur = 1;
            }
        }
        return res;
    }
}

class Solution2 {
    // Timeout
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int left = 1, right = n / 2;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (validArr(nums, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean validArr(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isValid(nums, i, k) && isValid(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(List<Integer> nums, int start, int k) {
        for (int i = start + 1; i < start + k; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
