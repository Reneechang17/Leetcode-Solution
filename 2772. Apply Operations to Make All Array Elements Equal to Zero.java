// Medium
// Difference Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/apply-operations-to-make-all-array-elements-equal-to-zero/

class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int cur = 0;
        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            cur += diff[i];

            int actual = nums[i] + cur;
            if (actual < 0)
                return false;

            if (actual > 0) {
                if (i + k > n)
                    return false;

                cur -= actual;
                diff[i + k] += actual;
            }
        }
        return true;
    }
}

class Solution2 {
    // Sliding Window -> Timeout
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            if (nums[i] == 0)
                continue;

            int ops = nums[i]; // cur needs nums[i] times ops

            // for [i, i+k-1] do ops's times ops
            for (int j = i; j < i + k; j++) {
                nums[j] -= ops;
                if (nums[j] < 0)
                    return false;
            }
        }
        
        for (int i = n - k + 1; i < n; i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }
}
